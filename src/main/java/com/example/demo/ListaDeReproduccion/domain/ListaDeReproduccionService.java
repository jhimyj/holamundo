package com.example.demo.ListaDeReproduccion.domain;

import com.example.demo.ListaDeReproduccion.infrastructure.ListaDeReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaDeReproduccionService {
    @Autowired
    private ListaDeReproduccionRepository listaDeReproduccionRepository;



}
