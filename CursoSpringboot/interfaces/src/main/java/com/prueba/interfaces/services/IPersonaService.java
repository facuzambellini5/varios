package com.prueba.interfaces.services;

import com.prueba.interfaces.models.Persona;

import java.util.List;

public interface IPersonaService {

    public void crearPersona(Persona persona);
    public List<Persona> traerPersonas();
}
