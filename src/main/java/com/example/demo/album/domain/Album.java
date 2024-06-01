package com.example.demo.album.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    private String nombre;

    private Date fechaDeLanzamiento;
}
