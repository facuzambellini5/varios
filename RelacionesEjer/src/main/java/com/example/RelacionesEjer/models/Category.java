package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    private String description;

    @ManyToOne
    @JoinColumn(name = "commerce_id")
    private Commerce commerce;
}
