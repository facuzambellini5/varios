package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderProduct;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "code_product")
    private Product product;

    private int quantity;






}
