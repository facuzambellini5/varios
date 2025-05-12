package com.ejerciciopractico.cursosprogramacion.controllers;

import com.ejerciciopractico.cursosprogramacion.dto.CursoTemaDTO;
import com.ejerciciopractico.cursosprogramacion.models.Curso;
import com.ejerciciopractico.cursosprogramacion.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    ICursoService icursoServ;


    @PostMapping("/crear")
    public String saveCurso(@RequestBody Curso curso){
        icursoServ.saveCurso(curso);
        return "Curso creado correctamente.";
    }

    @GetMapping("/traer")
    public List<Curso> getCursos(){
        return icursoServ.getCursos();
    }

    @GetMapping("/traer/{id}")
    public Curso getById(@PathVariable Long id){
        return icursoServ.getById(id);
    }

    @PutMapping("/editar")
    public Curso editCurso(@RequestBody Curso curso){
        icursoServ.editCurso(curso);
        System.out.println("Curso recibido: "+curso);
        return icursoServ.getById(curso.getId_curso());
    }

    @GetMapping("/temas/traer/{id}")
    public CursoTemaDTO getTemasCurso(@PathVariable Long id){
        return icursoServ.getTemasCurso(id);
    }

    @GetMapping("/buscar/{palabra}")
    public List<Curso> getCursosPalabra(@PathVariable String palabra){

        return icursoServ.getCursosPalabra(palabra);
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteCurso(@PathVariable Long id){
        if(icursoServ.getById(id) != null) {
            icursoServ.deleteCurso(id);
            return "Curso borrado correctamente.";
        }else {
            return "No se ha encontrado el curso.";
        }
    }
}
