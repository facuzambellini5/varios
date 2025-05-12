package com.prueba.EjerciciosPracticos.repositories;

import com.prueba.EjerciciosPracticos.models.JugadorBasquet;

import java.util.ArrayList;

public interface IJugadorBasquetRepository {

    public void guardar(JugadorBasquet jugadorBasquet);

    public ArrayList<JugadorBasquet> traerJugadores();

    public Double promedioEstatura();
}
