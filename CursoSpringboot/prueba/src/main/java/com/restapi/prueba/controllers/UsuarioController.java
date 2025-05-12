package com.restapi.prueba.controllers;

import com.restapi.prueba.models.UsuarioModel;
import com.restapi.prueba.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/obtener")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping("/grabar")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        System.out.println("Guardado exitosamente!");
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/buscar/{id}")
    public Optional<UsuarioModel> obtenerPorId(@PathVariable Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable Long id){
        if(this.usuarioService.eliminarPorId(id)){
            return "Eliminado exitosamente.";
        }else{
            return "No se pudo eliminar.";
        }
    }
}
