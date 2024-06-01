package com.example.demo.ListaDeReproduccion.domain;


import com.example.demo.cancion.domain.Cancion;
import com.example.demo.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @OneToMany(mappedBy = "listaDeReproduccion")
    private List<Cancion> canciones= new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private User user;


}