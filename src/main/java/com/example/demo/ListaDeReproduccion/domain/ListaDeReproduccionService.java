package com.example.demo.ListaDeReproduccion.domain;

import com.example.demo.ListaDeReproduccion.infrastructure.ListaDeReproduccionRepository;
import com.example.demo.cancion.domain.Cancion;
import com.example.demo.cancion.infrastructure.CancionRepository;
import com.example.demo.events.HelloEmailEvent;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDeReproduccionService {
    @Autowired
    private ListaDeReproduccionRepository listaDeReproduccionRepository;

    @Autowired
    private UserRepository<User> userRepository;


    @Autowired
    private CancionRepository cancionRepository;



    public List<Cancion> getCancionesListaDeReproduccion(Long playlist_id) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(playlist_id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de reproducción no encontrada"));

        return listaDeReproduccion.getCanciones();
    }

    public void deleteCancionFromListaDeReproduccion(Long playlist_id, int song_id) throws BadRequestException {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(playlist_id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de reproducción no encontrada"));

        Cancion cancion = cancionRepository.findById(song_id)
                .orElseThrow(() -> new EntityNotFoundException("Cancion no encontrada"));

        List<Cancion> listaCanciones = listaDeReproduccion.getCanciones();

        if (!listaCanciones.contains(cancion)) {
            throw new BadRequestException("Cancion no pertenece a la lista de reproducción.");
        }

        listaCanciones.remove(cancion);
        listaDeReproduccion.setCanciones(listaCanciones);

        listaDeReproduccionRepository.save(listaDeReproduccion);
    }

    public void addCancionToListaDeReproduccion(Long playlist_id, int cancion_id) {
        ListaDeReproduccion listaDeReproduccion = listaDeReproduccionRepository.findById(playlist_id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de reproducción no encontrada"));

        Cancion cancion = cancionRepository.findById(cancion_id)
                .orElseThrow(() -> new EntityNotFoundException("Cancion no encontrada"));

        List<Cancion> listaCanciones = listaDeReproduccion.getCanciones();

        listaCanciones.add(cancion);

        listaDeReproduccion.setCanciones(listaCanciones);
        listaDeReproduccionRepository.save(listaDeReproduccion);
    }

    public ListaDeReproduccion getLista(Long lista_id) {
        return listaDeReproduccionRepository.findById(lista_id)
                .orElseThrow(() -> new EntityNotFoundException("Lista de reproducción no encontrada"));
    }


}
