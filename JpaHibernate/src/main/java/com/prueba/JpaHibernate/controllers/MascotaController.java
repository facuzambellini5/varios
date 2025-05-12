package com.prueba.JpaHibernate.controllers;

import com.prueba.JpaHibernate.models.Mascota;
import com.prueba.JpaHibernate.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private IMascotaService iMascotaService;

    @GetMapping("/traer")
    public List<Mascota> getMascotas(){
        return iMascotaService.getMascotas();
    }

    @PostMapping("/save")
    public String saveMascota(@RequestBody Mascota mascota){
        iMascotaService.saveMascota(mascota);
        return "La mascota se ha guardado correctamente.";
    }

    @DeleteMapping("/borrar")
    public String deleteMascota(Long id){
        iMascotaService.deleteMascota(id);
        return "Se ha borrado correctamente.";
    }

    @GetMapping("/find/{id}")
    public Mascota findMascota(@PathVariable Long id){
        return iMascotaService.findMascota(id);
    }

    @PutMapping("/edit{id_original}")
    public Mascota editMascota(@PathVariable Long id_original,
                               @RequestParam(required = false,name = "id")Long idNueva,
                               @RequestParam(required = false,name = "nombre")String nombreNuevo,
                               @RequestParam(required = false,name = "especie")String especieNueva,
                               @RequestParam(required = false,name = "raza")String razaNueva,
                               @RequestParam(required = false,name = "color")String colorNuevo){

        iMascotaService.editMascota(id_original,idNueva,nombreNuevo,especieNueva,razaNueva,colorNuevo);

        return iMascotaService.findMascota(id_original);
    }

}
