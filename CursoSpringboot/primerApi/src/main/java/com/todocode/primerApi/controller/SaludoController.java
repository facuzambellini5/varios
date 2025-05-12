package com.todocode.primerApi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ejer")
public class SaludoController {

    @GetMapping("/1/{num1}/{num2}")
    public int sumarNumeros(@PathVariable int num1,
                            @PathVariable int num2){
        return num1+num2;
    }

    @GetMapping("/2")
    public String indiceMasaCorporal(@RequestParam double imc){
        if(imc >= 1 && imc <= 18.5){
            return "^Peso insuficiente.";
        } else if (imc >= 18.6 && imc <= 24.9) {
            return "Peso normal.";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso.";
        } else if (imc >= 30) {
            return "Obesidad.";
        }else {
            return "Valor incorrecto";
        }
    }

    @GetMapping("/holaname/{nombre}/{edad}")
    public String holaNombre(@PathVariable String nombre, @PathVariable int edad){
        return "Hola " + nombre + " tu edad es: " + edad;
    }

    @GetMapping("/galoneslitros")
    public String galonesALitros(@RequestParam double galones){
        double litros = galones * 3.78541;
        return galones+" galones equivalen a "+litros+" litros.";
    }

}
