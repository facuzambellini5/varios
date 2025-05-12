package com.prueba.negocio.services;

import com.prueba.negocio.models.ClienteModel;
import com.prueba.negocio.models.PedidoModel;
import com.prueba.negocio.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente (ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> obtenerPorId (long id){
        return clienteRepository.findById(id);
    }
    public ArrayList<ClienteModel> obtenerPorNombre (String nombre){
        return clienteRepository.findByNombre(nombre);
    }

    public ClienteModel obtenerPorPedidos(PedidoModel pedido){
        return clienteRepository.findByPedidos(pedido);
    }
}
