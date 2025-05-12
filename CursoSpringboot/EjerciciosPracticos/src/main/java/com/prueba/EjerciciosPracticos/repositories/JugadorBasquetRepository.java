package com.prueba.EjerciciosPracticos.repositories;

import com.prueba.EjerciciosPracticos.models.JugadorBasquet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class JugadorBasquetRepository implements IJugadorBasquetRepository{

    ArrayList<JugadorBasquet> lista = new ArrayList<>();

    @Override
    public void guardar(JugadorBasquet jugador) {
        lista.add(jugador);
    }

    @Override
    public ArrayList<JugadorBasquet> traerJugadores() {
        return lista;
    }

    @Override
    public Double promedioEstatura() {
        int sumaEstatura =0;
        for (JugadorBasquet jugador : lista){
            sumaEstatura +=jugador.getEstatura();
        }
        return (double) (sumaEstatura / lista.size());
    }
}
