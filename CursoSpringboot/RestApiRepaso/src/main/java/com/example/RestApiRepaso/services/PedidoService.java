package com.example.RestApiRepaso.services;

import com.example.RestApiRepaso.models.Pedido;
import com.example.RestApiRepaso.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    PedidoRepository pedidoRepo;

    @Override
    public List<Pedido> getPedidos() {
        return pedidoRepo.findAll();
    }

    @Override
    public void createPedido(Pedido pedido) {
        pedidoRepo.save(pedido);
    }

    @Override
    public Pedido getById(Long id) {
        return pedidoRepo.findById(id).orElse(null);
    }

    @Override
    public void deletePedido(Long id) {
        Pedido pedido = this.getById(id);
        pedidoRepo.deleteById(id);
    }

    @Override
    public Pedido editPedido(Long id,String descripcion, LocalDate fecha, Double senia, Double saldo, Double total, String cliente) {
        Pedido pedido = this.getById(id);

        pedido.setDescripcion(descripcion);
        pedido.setFecha(fecha);
        pedido.setSenia(senia);
        pedido.setSaldo(saldo);
        pedido.setTotal(total);
        pedido.setCliente(cliente);

        pedidoRepo.save(pedido);
        return pedido;
    }

    @Override
    public void savePedido(Pedido pedido) {
        pedidoRepo.save(pedido);
    }
}
