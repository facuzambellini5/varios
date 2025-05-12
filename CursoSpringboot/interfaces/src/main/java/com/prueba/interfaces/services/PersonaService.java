package com.prueba.interfaces.services;

import com.prueba.interfaces.models.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

//    logica negocio
    @Override
    public void crearPersona(Persona persona) {

    }

    @Override
    public List<Persona> traerPersonas() {
        return List.of();
    }



}
