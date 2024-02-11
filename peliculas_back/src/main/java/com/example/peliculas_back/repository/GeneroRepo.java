package com.example.peliculas_back.repository;

import com.example.peliculas_back.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface GeneroRepo extends JpaRepository<Genero, Long> {

    @Query(
            value = "SELECT nombre FROM genero",
            nativeQuery = true
    )
    Set<String> findAllGenero();

}
