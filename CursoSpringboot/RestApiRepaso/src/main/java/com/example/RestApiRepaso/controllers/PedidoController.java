package com.example.RestApiRepaso.controllers;

import com.example.RestApiRepaso.models.Pedido;
import com.example.RestApiRepaso.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    IPedidoService ipedidoServ;

    @GetMapping("/traer")
    public List<Pedido> getPedidos(){
        return ipedidoServ.getPedidos();
    }

    @PostMapping("/crear")
    public String createPedido(@RequestBody Pedido pedido){
        ipedidoServ.createPedido(pedido);
        return "Pedido creado correctamente.";
    }

    @GetMapping("/traer/{id}")
    public Pedido getById(@PathVariable Long id){
        return ipedidoServ.getById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteById(@PathVariable Long id){
        ipedidoServ.deletePedido(id);
        return "Pedido Eliminado.";
    }

    @PutMapping("/editar/{id}")
    public Pedido editPedido(@PathVariable Long id,
                             @RequestParam(required = false, name = "descripcion") String descripcion,
                             @RequestParam(required = false, name = "fecha")LocalDate fecha,
                             @RequestParam(required = false, name = "seña")Double senia,
                             @RequestParam(required = false, name = "saldo")Double saldo,
                             @RequestParam(required = false, name = "total")Double total,
                             @RequestParam(required = false, name = "cliente")String cliente){

        Pedido pedido = this.getById(id);
        pedido.setDescripcion(descripcion);
        pedido.setFecha(fecha);
        pedido.setSenia(senia);
        pedido.setSaldo(saldo);
        pedido.setTotal(total);
        pedido.setCliente(cliente);

        ipedidoServ.savePedido(pedido);
        return pedido;
    }



}
