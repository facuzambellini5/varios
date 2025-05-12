package com.ejerciciopractico.cursosprogramacion.services;

import com.ejerciciopractico.cursosprogramacion.dto.TemaDTO;
import com.ejerciciopractico.cursosprogramacion.models.Curso;
import com.ejerciciopractico.cursosprogramacion.models.Tema;
import com.ejerciciopractico.cursosprogramacion.repositories.ICursoRepository;
import com.ejerciciopractico.cursosprogramacion.repositories.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService implements ITemaService{
    //implementar metodos

    @Autowired
    ITemaRepository temaRepo;

    @Autowired
    ICursoRepository cursoRepo;

    @Override
    public void saveTema(TemaDTO temaDTO) {

        Tema tema = new Tema();
        Curso curso = cursoRepo.findById(temaDTO.getId_curso()).orElse(null);

        tema.setNombre(temaDTO.getNombre());
        tema.setDescripcion(temaDTO.getDescripcion());
        tema.setCurso(curso);
        
        curso.getListaDeTemas().add(tema);

        cursoRepo.save(curso);
        temaRepo.save(tema);
    }

    @Override
    public void saveTema(Tema tema) {
        temaRepo.save(tema);
    }

    @Override
    public List<Tema> getTemas() {
        return temaRepo.findAll();
    }

    @Override
    public Tema getById(Long id) {
        return temaRepo.findById(id).orElse(null);
    }

    @Override
    public void editTema(Tema tema) {
        this.saveTema(tema);
    }

    @Override
    public void deleteTema(Long id) {
        temaRepo.deleteById(id);
    }
}
