package com.prueba.EjerciciosPracticos.controllers;

import com.prueba.EjerciciosPracticos.services.IParcialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcialController {

    @Autowired
    IParcialService parcialService;

    @GetMapping("/promedio")
    public Double calcularPromedio(@RequestParam Double num1,
                                   @RequestParam Double num2,
                                   @RequestParam Double num3){
        return parcialService.calcularPromedio(num1,num2,num3);
    }


}
