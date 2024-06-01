package com.example.demo.cancion.domain;

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
}
