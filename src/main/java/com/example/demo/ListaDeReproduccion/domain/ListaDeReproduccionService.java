package com.example.demo.ListaDeReproduccion.domain;

import com.example.demo.ListaDeReproduccion.infrastructure.ListaDeReproduccionRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaDeReproduccionService {
    @Autowired
    private ListaDeReproduccionRepository listaDeReproduccionRepository;

    @Autowired
    private UserRepository<User> userRepository;

    public String crear(int id, ListaDeReproduccion listaDeReproduccion){
        User user = userRepository.findById(id).orElseThrow();
        listaDeReproduccion.setUser(user);
        listaDeReproduccionRepository.save(listaDeReproduccion);
        return "listasdereproduccion/"+listaDeReproduccion.getId();
    }
}
