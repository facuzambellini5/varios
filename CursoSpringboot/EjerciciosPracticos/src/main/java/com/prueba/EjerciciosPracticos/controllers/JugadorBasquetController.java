package com.prueba.EjerciciosPracticos.controllers;

import com.prueba.EjerciciosPracticos.models.JugadorBasquet;
import com.prueba.EjerciciosPracticos.services.IJugadorBasquetService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/jugador")
public class JugadorBasquetController {

    @Autowired
    IJugadorBasquetService ijugadorBasquetService;

    @PostMapping("/guardar")
    public String guardarJugador(@RequestBody JugadorBasquet jugador){
        ijugadorBasquetService.guardarJugador(jugador);
        return "Jugador: "+jugador.getNombre() +" guardado correctamente.";
    }

    @GetMapping("/lista")
    public ArrayList<JugadorBasquet> traerJugadores(){
        return ijugadorBasquetService.traerJugadores();
    }

    @GetMapping("/promedioestatura")
    public Double promedioEstatura(){
        System.out.println("El promedio de las edades de todos los jugadores es: ");
        return ijugadorBasquetService.promedioEstatura();
    }
}
