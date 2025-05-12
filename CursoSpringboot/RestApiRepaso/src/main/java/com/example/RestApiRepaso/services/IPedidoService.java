package com.example.RestApiRepaso.services;

import com.example.RestApiRepaso.models.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface IPedidoService {


    public List<Pedido> getPedidos();

    public void createPedido(Pedido pedido);

    public Pedido getById(Long id);

    public void deletePedido(Long id);

    public Pedido editPedido(Long id, String descripcion, LocalDate fecha, Double senia, Double saldo, Double total, String cliente);

    public void savePedido(Pedido pedido);







}
