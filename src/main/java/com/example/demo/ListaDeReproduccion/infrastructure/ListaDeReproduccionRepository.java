package com.example.demo.ListaDeReproduccion.infrastructure;

import com.example.demo.ListaDeReproduccion.domain.ListaDeReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaDeReproduccionRepository extends JpaRepository<ListaDeReproduccion, Long> {
}
