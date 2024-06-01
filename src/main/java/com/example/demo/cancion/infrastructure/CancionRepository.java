package com.example.demo.cancion.infrastructure;

import com.example.demo.cancion.domain.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion,Integer> {

}
