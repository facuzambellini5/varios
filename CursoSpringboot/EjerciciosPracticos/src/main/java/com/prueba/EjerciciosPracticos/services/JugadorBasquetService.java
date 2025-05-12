package com.prueba.EjerciciosPracticos.services;

import com.prueba.EjerciciosPracticos.models.JugadorBasquet;
import com.prueba.EjerciciosPracticos.repositories.IJugadorBasquetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JugadorBasquetService implements IJugadorBasquetService{

    @Autowired
    IJugadorBasquetRepository iJugadorBasquetRepository;

    @Override
    public void guardarJugador(JugadorBasquet jugador) {
        iJugadorBasquetRepository.guardar(jugador);
    }

    @Override
    public ArrayList<JugadorBasquet> traerJugadores() {
        return iJugadorBasquetRepository.traerJugadores();
    }

    @Override
    public Double promedioEstatura(){
        return iJugadorBasquetRepository.promedioEstatura();
    }
}
