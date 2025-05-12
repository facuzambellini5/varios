package com.example.pruebaconcesionaria.controllers;

import com.example.pruebaconcesionaria.models.Cliente;
import com.example.pruebaconcesionaria.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @PostMapping("/guardar")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "Cliente creado correctamente.";
    }

    @GetMapping("/traer")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/traer/{idCliente}")
    public Cliente getClienteById(@PathVariable Long idCliente){
        return clienteService.getClienteById(idCliente);
    }

    @PutMapping("/editar")
    public Cliente editCliente(@RequestBody Cliente cliente){
        return clienteService.editCliente(cliente);
    }

    @DeleteMapping("/borrar/{idCliente}")
    public String deleteCliente(@PathVariable Long idCliente){
        return clienteService.deleteCliente(idCliente);
    }
}
