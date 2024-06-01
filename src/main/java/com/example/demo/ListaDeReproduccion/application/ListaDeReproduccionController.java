package com.example.demo.ListaDeReproduccion.application;

import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lista")
public class ListaDeReproduccionController {
    @Autowired
    private ListaDeReproduccionService listaDeReproduccionService;

    //GET /users/{user_id}/playlists
    //GET /playlists/{playlist_id}
    //POST /users/{user_id}/playlists
    //PUT /playlists/{playlist_id}
    //DELETE /playlists/{playlist_id}
}
