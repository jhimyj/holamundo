package com.example.demo.cancion.application;

import com.example.demo.cancion.domain.Cancion;
import com.example.demo.cancion.domain.CancionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    @GetMapping
    public ResponseEntity<List<Cancion>> getCanciones() {
        return ResponseEntity.ok(cancionService.getCanciones());
    }

    @PostMapping
    public ResponseEntity<Cancion> createCancion(@RequestBody Cancion cancion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cancionService.createCancion(cancion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCancion(@RequestBody Cancion cancionUpdates,
                                              @PathVariable int id) {
        try {
            cancionService.updateCancion(cancionUpdates, id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable int id) {
        try {
            cancionService.deleteCancion(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}