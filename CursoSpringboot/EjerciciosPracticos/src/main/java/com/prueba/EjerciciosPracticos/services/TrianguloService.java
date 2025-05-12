package com.prueba.EjerciciosPracticos.services;

import org.springframework.stereotype.Service;

@Service
public class TrianguloService implements ITrianguloService{

    @Override
    public Double calcularArea(double base, double altura) {
        return (base * altura) / 2;
    }
}
