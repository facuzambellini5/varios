package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String name;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "id_profile")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "owner")
    private List<Commerce> commerces;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {
    }


}
