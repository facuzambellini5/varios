package com.prueba.JpaHibernate.services;

import com.prueba.JpaHibernate.models.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona(Persona persona);

    public void deletePersona(Long id);

    public Persona findPersona(Long id);

    public void editPersona(Long idOriginal,
                            Long idNueva,
                            String nombreNuevo,
                            String apellidoNuevo,
                            int edadNueva);

    public void editPersona(Persona persona);
}
