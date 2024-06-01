package com.example.demo.artista.domain;

import com.example.demo.cancion.domain.Cancion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArtist;

    @Column(nullable = false)
    private String nombre;
    @OneToMany(mappedBy = "artista")
    private List<Cancion> canciones;

}
