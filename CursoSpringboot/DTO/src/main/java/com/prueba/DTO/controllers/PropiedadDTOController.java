package com.prueba.DTO.controllers;

import com.prueba.DTO.dto.PropiedadDTO;
import com.prueba.DTO.models.Inquilino;
import com.prueba.DTO.models.Propiedad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropiedadDTOController {


    @GetMapping("/propiedad/{id}")
    public PropiedadDTO traerPropiedad(@PathVariable Long id){

        Propiedad propiedad = new Propiedad(2L,"Casa","calle 2",150.0,150000.0);
        Inquilino inquilino = new Inquilino(1L,11222457,"Pepe","Alfonzo","Profesor");


        PropiedadDTO propiedadDTO = new PropiedadDTO();

        propiedadDTO.setId_propiedad(propiedad.getId_propiedad());
        propiedadDTO.setTipo_propiedad(propiedad.getTipo_propiedad());
        propiedadDTO.setDireccion(propiedad.getDireccion());
        propiedadDTO.setNombre(inquilino.getNombre());
        propiedadDTO.setApellido(inquilino.getApellido());
        return propiedadDTO;
    }
}
