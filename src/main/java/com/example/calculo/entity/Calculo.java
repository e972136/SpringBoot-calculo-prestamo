package com.example.calculo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@EntityScan
public class Calculo {
    @Positive
    Double monto;

    @Positive
    Integer meses;

    @Positive
    Double interes;

    String pago;

    public String getPago(){
        Double lInteres=0.0;
        BigDecimal pagoCalculo=BigDecimal.ZERO;
        try {
            lInteres = interes / 100.0;
            Double v = (1.0 + (lInteres / 12.0));
            pagoCalculo = BigDecimal.valueOf((monto * (lInteres / 12.0)) / (1.0 - Math.pow(v, -meses)));
        }catch (Exception e){
            return "0.00";
        }
        DecimalFormat formato = new DecimalFormat("#,###.##");
        String v = formato.format(pagoCalculo.doubleValue());
        return v;
    }
}
