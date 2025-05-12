package com.prueba.posteoEjercicio.controllers;

import com.prueba.posteoEjercicio.models.PosteoModel;
import com.prueba.posteoEjercicio.services.IPosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PosteoController {

    @Autowired
    IPosteoService posteoService;

    @GetMapping("/posteos")
    public List<PosteoModel> traerPosteos(){
        return posteoService.traerTodo();
    }


}
