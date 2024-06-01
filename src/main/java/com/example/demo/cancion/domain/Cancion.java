package com.example.demo.cancion.domain;

import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccion;
import com.example.demo.album.domain.Album;
import com.example.demo.artista.domain.Artista;
import com.example.demo.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@Table(name = "cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSong ;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int artistalD;

    @Column(nullable = false)
    private int idAlbum;

    @Column(nullable = false)
    private int duracion;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Album album;

    @ManyToOne
    @JoinColumn
    private Artista artista;

    @ManyToOne
    @JoinColumn
    private ListaDeReproduccion listaDeReproduccion;

}
