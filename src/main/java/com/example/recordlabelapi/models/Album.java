package com.example.recordlabelapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Album {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "release_year")
    @JsonProperty("release_year")
    @NotNull
    private Short releaseYear;

    @Column(name = "genre")
    @NotEmpty
    private String genre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "artist_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Artist artist;


    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}

    public Short getReleaseYear() {return this.releaseYear;}
    public void setReleaseYear(Short releaseYear) {this.releaseYear = releaseYear;}

    public String getGenre() {return this.genre;}
    public void setGenre(String genre) {this.genre = genre;}

    public Artist getArtist() {return this.artist;}
    public void setArtist(Artist artist) {this.artist = artist;}
}
