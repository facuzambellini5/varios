package com.prueba.posteoEjercicio.services;

import com.prueba.posteoEjercicio.models.PosteoModel;
import com.prueba.posteoEjercicio.repositories.IPosteoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PosteoService implements IPosteoService{

    @Autowired
    IPosteoRepository posteoRepository;


    @Override
    public List<PosteoModel> traerTodo() {
        return posteoRepository.traerTodos();
    }
}
