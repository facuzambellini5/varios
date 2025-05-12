package com.ejerciciopractico.cursosprogramacion.controllers;

import com.ejerciciopractico.cursosprogramacion.dto.TemaDTO;

import com.ejerciciopractico.cursosprogramacion.models.Tema;
import com.ejerciciopractico.cursosprogramacion.services.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    ITemaService temaServ;

    @GetMapping("/traer")
    public List<Tema> getTemas(){
        return temaServ.getTemas();
    }

    @PostMapping("/crear")
    public String saveTema(@RequestBody TemaDTO temaDTO){
        temaServ.saveTema(temaDTO);
        return "Tema guardado correctamente.";
    }

    @PutMapping("/editar")
    public String editTema(@RequestBody Tema tema){
        temaServ.editTema(tema);
        return "Se ha editado correctamente.";
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteTema(@PathVariable Long id){
        if(temaServ.getById(id) != null) {
            temaServ.deleteTema(id);
            return "Tema borrado correctamente.";
        }else{
            return "No se ha encontrado el tema.";
        }
    }
}
