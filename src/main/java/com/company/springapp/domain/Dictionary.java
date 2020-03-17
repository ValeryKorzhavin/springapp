package com.company.springapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dictionary", schema = "springapp")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public abstract class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ext_id")
    private String extId;

}
