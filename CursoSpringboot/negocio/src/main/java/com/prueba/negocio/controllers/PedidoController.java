package com.prueba.negocio.controllers;

import com.prueba.negocio.models.ClienteModel;
import com.prueba.negocio.models.PedidoModel;
import com.prueba.negocio.services.ClienteService;
import com.prueba.negocio.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/obtener")
    public ArrayList<PedidoModel> obtenerPedidos(){
        return pedidoService.obtenerPedidos();
    }

    @PostMapping("/agregar")
    public PedidoModel agregarPedido(@RequestBody PedidoModel pedido){
        return pedidoService.guardarPedido(pedido);
    }


}
