package com.prueba.JpaHibernate.services;

import com.prueba.JpaHibernate.models.Persona;
import com.prueba.JpaHibernate.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository personaRepository;


    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return personaRepository.findById(id).orElse(null); //VER SI FUNCIONA DIRECTAMENTE CON ESTO
    }

    @Override
    public void editPersona(Long id_original, Long idNueva, String nombreNuevo, String apellidoNuevo, int edadNueva) {
        //buscamos esa persona a taves de nuestro metodo (por eso el this.) que va a traer a la persona desde la BD
        Persona persona = this.findPersona(id_original);

        //seteamos los nuevos valores a nuestra persona
        persona.setId(idNueva);
        persona.setNombre(nombreNuevo);
        persona.setApellido(apellidoNuevo);
        persona.setEdad(edadNueva);

        //la guardamos a traves de nuestro metodo save(por eso el this.)
        //SOBREESCRIBE nuestro objeto persona y lo guarda de nuevo en la BD
        this.savePersona(persona);

    }

    @Override
    public void editPersona(Persona persona) {
        this.savePersona(persona);
    }
}
