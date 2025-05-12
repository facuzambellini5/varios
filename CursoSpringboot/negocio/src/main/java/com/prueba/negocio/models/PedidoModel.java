package com.prueba.negocio.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descripcion;
    private double senia;
    private double saldo;
    private double total;
    private String tipoPedido;
    @JsonFormat
    private LocalDate fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ClienteModel cliente;

    public PedidoModel() {
    }

    public PedidoModel(long id, String descripcion, double senia, double saldo, double total, String tipoPedido, LocalDate fecha, ClienteModel cliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.senia = senia;
        this.saldo = saldo;
        this.total = total;
        this.tipoPedido = tipoPedido;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSenia() {
        return senia;
    }

    public void setSenia(double senia) {
        this.senia = senia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}
