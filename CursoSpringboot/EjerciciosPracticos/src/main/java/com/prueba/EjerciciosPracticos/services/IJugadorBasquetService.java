package com.prueba.EjerciciosPracticos.services;

import com.prueba.EjerciciosPracticos.models.JugadorBasquet;

import java.util.ArrayList;

public interface IJugadorBasquetService {

    public void guardarJugador(JugadorBasquet jugadorBasquet);

    public ArrayList<JugadorBasquet> traerJugadores();

    public Double promedioEstatura();

}
