package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commerce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommerce;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "branch_of")
    private Commerce branchOf;

    @OneToMany(mappedBy = "branchOf")
    private List<Commerce> branches;

    @OneToMany(mappedBy = "commerce")
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User owner;

    @OneToMany(mappedBy = "commerce")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "commerce_event",
            joinColumns = @JoinColumn(name = "id_commerce"),
            inverseJoinColumns = @JoinColumn(name = "id_event")
    )
    private List<Event> events;



    public Commerce() {
    }


}
