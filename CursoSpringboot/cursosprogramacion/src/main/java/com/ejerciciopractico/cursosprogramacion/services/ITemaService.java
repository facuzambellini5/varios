package com.ejerciciopractico.cursosprogramacion.services;

import com.ejerciciopractico.cursosprogramacion.dto.TemaDTO;
import com.ejerciciopractico.cursosprogramacion.models.Curso;
import com.ejerciciopractico.cursosprogramacion.models.Tema;

import java.util.List;

public interface ITemaService {

    public void saveTema(TemaDTO tema);

    public void saveTema(Tema tema);

    public List<Tema> getTemas();

    public Tema getById(Long id);

    public void editTema(Tema tema);

    public void deleteTema(Long id);

}
