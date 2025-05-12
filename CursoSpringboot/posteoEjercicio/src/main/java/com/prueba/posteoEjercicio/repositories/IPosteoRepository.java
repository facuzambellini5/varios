package com.prueba.posteoEjercicio.repositories;

import com.prueba.posteoEjercicio.models.PosteoModel;

import java.util.List;

public interface IPosteoRepository {

    public List<PosteoModel> traerTodos();
}
