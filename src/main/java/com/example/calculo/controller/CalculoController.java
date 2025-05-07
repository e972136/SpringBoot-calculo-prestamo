package com.example.calculo.controller;

import com.example.calculo.entity.Calculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
public class CalculoController {
    @GetMapping({"/","/calculo"})
    String index( Calculo calculo){
        System.err.println("index");
        return "index";
    }

    @GetMapping("/nuevo_calculo")
    String calculado(@Valid Calculo calculo, BindingResult error, Model model){
        System.err.println("calculado");
        if(error.hasErrors()){
            System.out.println("hay error" + error.toString());
            return "index";
        }
//        Calculo nuevo = Calculo.of(calculo.getMonto(),calculo.getMeses(),calculo.getInteres(), BigDecimal.ZERO);
//        System.out.println(nuevo);
        model.addAttribute("calculo",calculo);
        return "index";
    }
}
