package com.ejerciciopractico.cursosprogramacion.services;

import com.ejerciciopractico.cursosprogramacion.dto.CursoTemaDTO;
import com.ejerciciopractico.cursosprogramacion.models.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICursoService {

    public void saveCurso(Curso curso);

    public List<Curso> getCursos();

    public Curso getById(Long id);

    public void editCurso(Curso curso);

    public void deleteCurso(Long id);

    public CursoTemaDTO getTemasCurso(Long id);

    public List<Curso> getCursosPalabra(String palabra);
}
