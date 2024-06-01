package com.example.demo.ListaDeReproduccion.application;

import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccion;
import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lista")
public class ListaDeReproduccionController {
    @Autowired
    private ListaDeReproduccionService listaDeReproduccionService;
    @PostMapping("/{id}")
    public ResponseEntity<Object> crear(@RequestBody ListaDeReproduccion listaDeReproduccion, @PathVariable int id){
        listaDeReproduccionService.crear(id,listaDeReproduccion);
        return  ResponseEntity.accepted().build();
    }
    //GET /users/{user_id}/playlists
    //GET /playlists/{playlist_id}
    //POST /users/{user_id}/playlists
    //PUT /playlists/{playlist_id}



    //DELETE /playlists/{playlist_id}

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int playlistId){
        listaDeReproduccionService.delete(playlistId);
        return ResponseEntity.noContent().build();
    }
}
