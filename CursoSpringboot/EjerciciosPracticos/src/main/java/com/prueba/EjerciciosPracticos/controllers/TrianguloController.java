package com.prueba.EjerciciosPracticos.controllers;

import com.prueba.EjerciciosPracticos.services.ITrianguloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/triangulo")
public class TrianguloController {

    @Autowired
    ITrianguloService trianguloService;

    @GetMapping("/area")
    public Double calcularArea(@RequestParam double base,
                               @RequestParam double altura){
        return trianguloService.calcularArea(base, altura);
    }
}
