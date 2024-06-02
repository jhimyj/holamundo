package com.example.demo.artista.domain;

import com.example.demo.artista.infrastructure.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaSevice {
    @Autowired
    private ArtistaRepository artistaRepository;

    public String crear(Artista artista){
        artistaRepository.save(artista);
        return "artista/"+artista.getIdArtist();
    }
}
