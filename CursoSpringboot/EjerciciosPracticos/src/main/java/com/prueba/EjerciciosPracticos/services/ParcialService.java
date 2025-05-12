package com.prueba.EjerciciosPracticos.services;


import org.springframework.stereotype.Service;

@Service
public class ParcialService implements IParcialService{


    @Override
    public Double calcularPromedio(Double num1,
                                   Double num2,
                                   Double num3) {
        return (num1+num2+num3) / 3;
    }
}
