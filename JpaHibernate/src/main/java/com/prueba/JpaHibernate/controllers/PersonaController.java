package com.prueba.JpaHibernate.controllers;

import com.prueba.JpaHibernate.models.Persona;
import com.prueba.JpaHibernate.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService ipersonaService;


    @GetMapping("/traer")
    public List<Persona> getPersonas(){
        return ipersonaService.getPersonas();
    }

    @PostMapping("/save")
    public String savePersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Se ha guardado correctamente";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "Se ha eliminado correctamente";
    }

    @GetMapping("/find/{id}")
    public Persona findPersona(@PathVariable Long id){
        return ipersonaService.findPersona(id);
    }


    //VER
    @PutMapping("/edit/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
                                @RequestParam (required = false,name = "id") Long idNueva,
                                @RequestParam (required = false,name = "nombre")String nombreNuevo,
                                @RequestParam (required = false, name = "apellido")String apellidoNuevo,
                                @RequestParam (required = false, name = "edad")int edadNueva){


        ipersonaService.editPersona(id_original,idNueva,nombreNuevo,apellidoNuevo,edadNueva);
        Persona persona = ipersonaService.findPersona(id_original);

        return persona;
    }

    //DEBE RECIBIR UN ID EXISTENTE porque sino creará un nuevo registro con datos duplicados...
    @PutMapping("/edit")
    public Persona editPersona(@RequestBody Persona persona){
        ipersonaService.editPersona(persona);
        return ipersonaService.findPersona(persona.getId());
    }
}
