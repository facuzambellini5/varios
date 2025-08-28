package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;

    private String description;


    @ManyToMany(mappedBy = "events")
    private List<Commerce> commerces;



}
