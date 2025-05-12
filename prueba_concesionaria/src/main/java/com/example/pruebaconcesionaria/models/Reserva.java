package com.example.pruebaconcesionaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private LocalDate fechaReserva;
    private Double sena;

    @OneToOne
    private Vehiculo vehiculo;

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;

    public Reserva() {
    }

    public Reserva(Long idReserva, LocalDate fechaReserva, Double sena, Vehiculo vehiculo, Cliente cliente) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.sena = sena;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Double getSena() {
        return sena;
    }

    public void setSena(Double sena) {
        this.sena = sena;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
