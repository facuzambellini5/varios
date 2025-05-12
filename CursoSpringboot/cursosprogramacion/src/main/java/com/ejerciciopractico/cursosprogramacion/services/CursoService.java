package com.ejerciciopractico.cursosprogramacion.services;

import com.ejerciciopractico.cursosprogramacion.dto.CursoTemaDTO;
import com.ejerciciopractico.cursosprogramacion.models.Curso;
import com.ejerciciopractico.cursosprogramacion.repositories.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService implements ICursoService{

    @Autowired
    ICursoRepository cursoRepo;

    @Override
    public void saveCurso(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public Curso getById(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }

    //DEBE RECIBIR UNA ID EXISTENTE, DE LO CONTRARIO CREARÁ UN NUEVO REGISTRO.
    @Override
    public void editCurso(Curso curso) {
        this.saveCurso(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public CursoTemaDTO getTemasCurso(Long id) {

        Curso curso = this.getById(id);
        CursoTemaDTO cursoTemaDTO = new CursoTemaDTO();

        cursoTemaDTO.setNombreCurso(curso.getNombre());
        cursoTemaDTO.setListaTemas(curso.getListaDeTemas());

        return cursoTemaDTO;
    }

    @Override
    public List<Curso> getCursosPalabra(String palabra) {
        List<Curso> listaCursos = this.getCursos();
        List<Curso> listaCursosPalabra = new ArrayList<>();

        for (Curso curso : listaCursos){
            if(curso.getNombre().contains(palabra)){
                listaCursosPalabra.add(curso);
            }
        }
        return listaCursosPalabra;
    }
}
