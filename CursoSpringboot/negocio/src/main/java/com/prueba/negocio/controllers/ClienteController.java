package com.prueba.negocio.controllers;

import com.prueba.negocio.models.ClienteModel;
import com.prueba.negocio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/obtener")
    public ArrayList<ClienteModel> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping("/agregar")
    public ClienteModel agregarCliente(@RequestBody ClienteModel cliente){
        return clienteService.guardarCliente(cliente);
    }
}
