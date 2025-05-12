package com.example.pruebaconcesionaria.models;

import com.example.pruebaconcesionaria.enums.EstadoVehiculo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;
    private String marca;
    private String modelo;
    private int anio;
    private Double precio;


    @Enumerated(EnumType.STRING)   // @Enumerated(EnumType.STRING), en la base de datos los valores se almacenan como texto
    private EstadoVehiculo estado; // ("DISPONIBLE", "RESERVADO", "VENDIDO"), lo que mejora la legibilidad y evita problemas si
                                   // se agregan nuevos estados en el futuro.

    //entidad dueña, por eso va el @JoinColumn.
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente cliente;


    public Vehiculo() {
    }

    public Vehiculo(Long idVehiculo, String marca, String modelo, int anio, Double precio, EstadoVehiculo estado) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.estado = estado;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }
}
