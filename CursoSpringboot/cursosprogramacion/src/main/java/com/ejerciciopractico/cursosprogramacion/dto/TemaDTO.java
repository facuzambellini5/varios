package com.ejerciciopractico.cursosprogramacion.dto;

public class TemaDTO {
    private String nombre;
    private String descripcion;
    private Long id_curso;

    public TemaDTO(String nombre, String descripcion, Long id_curso) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_curso = id_curso;
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

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }
}
