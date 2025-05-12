package com.ejerciciopractico.cursosprogramacion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tema;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonIgnore
    private Curso curso;

    public Tema() {
    }

    public Tema(Long id_tema, String nombre, String descripcion,Curso curso) {
        this.id_tema = id_tema;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.curso = curso;
    }

    public Long getId_tema() {
        return id_tema;
    }

    public void setId_tema(Long id_tema) {
        this.id_tema = id_tema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }


}
