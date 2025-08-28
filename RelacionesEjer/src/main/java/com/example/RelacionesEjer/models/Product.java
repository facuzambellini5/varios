package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeProduct;

    private String name;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;


}
