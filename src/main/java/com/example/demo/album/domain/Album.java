package com.example.demo.album.domain;

import com.example.demo.cancion.domain.Cancion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    private String nombre;

    private Date fechaDeLanzamiento;

    @OneToMany(mappedBy = "album")
    private List<Cancion> canciones= new ArrayList<>();
}
