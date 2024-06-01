package com.example.demo.ListaDeReproduccion.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ListaDeReproduccion {

    @Id
    @GeneratedValue
    private Long playlistId;

    private String nombre;

    private int idUser;

    private Date fechaDeCreacion;

    private Long id;

}