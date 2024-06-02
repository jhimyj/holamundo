package com.example.demo.cancion.domain;

import com.example.demo.cancion.infrastructure.CancionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    public List<Cancion> getCanciones() {
        return cancionRepository.findAll();
    }

    public Cancion createCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void updateCancion(Cancion cancionUpdates, int cancionId) {
        Cancion cancionToUpdate = cancionRepository.findById(cancionId)
                .orElseThrow(() -> new EntityNotFoundException("Cancion no encontrado"));

        cancionToUpdate.setTitulo(cancionUpdates.getTitulo());
        cancionToUpdate.setArtistaID(cancionUpdates.getArtistaID());
        cancionToUpdate.setIdAlbum(cancionUpdates.getIdAlbum());
        cancionToUpdate.setDuracion(cancionUpdates.getDuracion());

        cancionRepository.save(cancionToUpdate);
    }

    public void deleteCancion(int cancionId) {
        Cancion cancion = cancionRepository.findById(cancionId)
                .orElseThrow(() -> new EntityNotFoundException("Cancion no encontrado"));

        cancionRepository.delete(cancion);
    }

}