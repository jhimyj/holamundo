package com.example.demo.ListaDeReproduccion.application;

import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccion;
import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccionService;
import com.example.demo.cancion.domain.Cancion;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class ListaDeReproduccionController {
    @Autowired
    private ListaDeReproduccionService listaDeReproduccionService;


    @GetMapping("/{playlist_id}/songs")
    public ResponseEntity<List<Cancion>> getCancionesFromListaDeReproduccion(@PathVariable Long playlist_id) {
        try {
            return ResponseEntity.ok(listaDeReproduccionService.getCancionesListaDeReproduccion(playlist_id));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{playlist_id}/songs/{song_id}")
    public ResponseEntity<Cancion> deleteCancionFromListaDeReproduccion(@PathVariable Long playlist_id,
                                                                        @PathVariable int song_id) {
        try {
            listaDeReproduccionService.deleteCancionFromListaDeReproduccion(playlist_id, song_id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (BadRequestException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/{playlist_id}/songs/{song_id}")
    public ResponseEntity<Void> addCancionToListaDeReproduccion(@PathVariable Long playlist_id,
                                                                @RequestBody int song_id) {
        listaDeReproduccionService.addCancionToListaDeReproduccion(playlist_id, song_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{playlist_id}")
    public ResponseEntity<ListaDeReproduccion> getLista(@PathVariable Long playlist_id) {
        return ResponseEntity.ok(listaDeReproduccionService.getLista(playlist_id));
    }
    //GET /users/{user_id}/playlists
    //GET /playlists/{playlist_id}
    //POST /users/{user_id}/playlists
    //PUT /playlists/{playlist_id}
    //DELETE /playlists/{playlist_id}
}
