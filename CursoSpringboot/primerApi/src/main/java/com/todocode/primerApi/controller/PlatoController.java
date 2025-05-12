package com.todocode.primerApi.controller;

import com.todocode.primerApi.models.PlatoModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlatoController {


    @GetMapping("/plato/{num_plato}")
    @ResponseBody
    public PlatoModel obtenerPlatos(@PathVariable int num_plato){
        List<PlatoModel> listaPlatos = new ArrayList<>();

        listaPlatos.add(new PlatoModel(1,"Pastel de papa",5000,"bañado en queso"));
        listaPlatos.add(new PlatoModel(2,"Milanesa con puré",6500,"Milanesa frita o al horno"));
        listaPlatos.add(new PlatoModel(3,"Rissoto",4000,"Con varidedad de verduras"));
        listaPlatos.add(new PlatoModel(4,"Fideos a la bolognesa",4500,"con queso parmesano"));
        listaPlatos.add(new PlatoModel(5,"Tira de asado",7000,"Especialidad de la casa"));

        for(PlatoModel plato : listaPlatos){
            if(plato.getId() == num_plato){
                return plato;
            }
        }
        return null;
    }
}
