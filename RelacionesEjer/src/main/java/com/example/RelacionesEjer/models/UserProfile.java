package com.example.RelacionesEjer.models;

import jakarta.persistence.*;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfile;

    private String bio;

    @OneToOne(mappedBy = "userProfile")
    private User user;

    public UserProfile() {
    }

    public UserProfile(Long idProfile, String bio, User user) {
        this.idProfile = idProfile;
        this.bio = bio;
        this.user = user;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
