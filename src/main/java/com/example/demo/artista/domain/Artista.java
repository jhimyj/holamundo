package com.example.demo.artista.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArtist;

    @Column(nullable = false)
    private String nombre;
}
