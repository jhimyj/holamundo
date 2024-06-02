package com.example.demo.artista.application;

import com.example.demo.artista.domain.Artista;
import com.example.demo.artista.domain.ArtistaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
    @Autowired
    private ArtistaSevice artistaSevice;
    @PostMapping
    public ResponseEntity<Object> crearArtistas(@RequestBody Artista artista){
        artistaSevice.crear(artista);
        return  ResponseEntity.accepted().build();

    }
}