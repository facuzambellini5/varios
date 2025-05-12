package com.prueba.JpaHibernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;

    @OneToMany
    private List<Mascota> listaMascotas;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, int edad, Mascota unaMascota) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

}
