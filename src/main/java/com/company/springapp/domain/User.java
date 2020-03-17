package com.company.springapp.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user", schema = "springapp")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public User() {}

    public User(String name) {
        this.name = name;
    }

}
