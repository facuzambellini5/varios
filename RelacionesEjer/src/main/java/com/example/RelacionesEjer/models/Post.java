package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "id_post"),
            inverseJoinColumns = @JoinColumn(name = "tag")
    )
    private List<Tag> tags;


    @ManyToOne
    @JoinColumn(name = "id_commerce")
    private Commerce commerce;


}
