package com.prueba.negocio.services;

import com.prueba.negocio.models.ClienteModel;
import com.prueba.negocio.models.PedidoModel;
import com.prueba.negocio.repositories.ClienteRepository;
import com.prueba.negocio.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public PedidoModel guardarPedido (PedidoModel pedido){

        ClienteModel cliente = pedido.getCliente();
        if(cliente != null && (cliente.getId() == 0 || !clienteRepository.existsById(cliente.getId()))) {
            clienteRepository.save(cliente);
        }
        pedido.setCliente(cliente);
        return pedidoRepository.save(pedido);
    }

    public ArrayList<PedidoModel> obtenerPedidos(){
        return (ArrayList<PedidoModel>) pedidoRepository.findAll();
    }

    public Optional<PedidoModel> obtenerPorId(Long id){
        return pedidoRepository.findById(id);
    }

    public ArrayList<PedidoModel> obtenerPorCliente(ClienteModel cliente){
        return pedidoRepository.findByCliente(cliente);
    }

}
