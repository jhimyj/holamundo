package com.example.demo.ListaDeReproduccion.application;

import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccionService;
import com.example.demo.auth.dto.JwtAuthResponse;
import com.example.demo.auth.dto.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lista")
public class ListaDeReproduccionController {
    @Autowired
    private ListaDeReproduccionService listaDeReproduccionService;

    @Autowired
    private

    @PostMapping("/")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginReq req) {
        return ResponseEntity.ok(listaDeReproduccionService.login(req));
    }


    //GET /users/{user_id}/playlists
    //GET /playlists/{playlist_id}
    //POST /users/{user_id}/playlists
    //PUT /playlists/{playlist_id}
    //DELETE /playlists/{playlist_id}
}
