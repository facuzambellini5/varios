package com.prueba.posteoEjercicio.repositories;

import com.prueba.posteoEjercicio.models.PosteoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PosteoRepository implements IPosteoRepository{


    //VER SI FALTA EL AUTOWIRED O NO

    @Override
    public List<PosteoModel> traerTodos() {

        List<PosteoModel> posteos = new ArrayList<PosteoModel>();
        posteos.add(new PosteoModel(5L,"Arma tu PC!","Facu Gonzalez"));
        posteos.add(new PosteoModel(7L,"Curso Springboot","Jorge"));
        return posteos;
    }
}
