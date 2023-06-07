package com.example.recordlabelapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Artist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty
    private String name;


    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
}
