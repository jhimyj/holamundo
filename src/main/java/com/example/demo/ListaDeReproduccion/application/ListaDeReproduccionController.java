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


}
