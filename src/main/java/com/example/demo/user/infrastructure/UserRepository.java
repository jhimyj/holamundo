package com.example.demo.user.infrastructure;

import com.example.demo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository<T extends User> extends JpaRepository<T, Integer> {
    Optional<T> findByEmail(String correo);
}