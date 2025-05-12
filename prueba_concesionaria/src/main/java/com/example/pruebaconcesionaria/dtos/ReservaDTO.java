package com.example.pruebaconcesionaria.dtos;

import java.time.LocalDate;

public class ReservaDTO {

    private Long idReservaDTO;
    private LocalDate fechaReserva;
    private Double sena;
    private Long idVehiculo;
    private Long idCliente;

    public ReservaDTO() {
    }

    public ReservaDTO(LocalDate fechaReserva, Double sena, Long idVehiculo, Long idCliente, Long idReservaDTO) {
        this.fechaReserva = fechaReserva;
        this.sena = sena;
        this.idVehiculo = idVehiculo;
        this.idCliente = idCliente;
        this.idReservaDTO = idReservaDTO;
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

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdReservaDTO() {
        return idReservaDTO;
    }

    public void setIdReservaDTO(Long idReservaDTO) {
        this.idReservaDTO = idReservaDTO;
    }
}
