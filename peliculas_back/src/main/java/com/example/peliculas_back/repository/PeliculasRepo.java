package com.example.peliculas_back.repository;

import com.example.peliculas_back.model.Genero;
import com.example.peliculas_back.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface PeliculasRepo extends JpaRepository<Peliculas, Long> {

    @Query(
            value = "SELECT * FROM movies  WHERE nombre LIKE %:nombre%",
            nativeQuery = true
    )
    List<Peliculas> findPeliculasByNombre(String nombre);

    @Query(
            value = "SELECT * FROM movies  WHERE director LIKE %:director%",
            nativeQuery = true
    )
    List<Peliculas> findPeliculasByDirector(String director);


    List<Peliculas> findByFechaBetween(Date fechaInicio, Date fechaFin);


    @Query(value = "SELECT * FROM movies WHERE genero LIKE %:genero%", nativeQuery = true)
    List<Peliculas> findByGenero(String genero);

    @Query(
            value = "SELECT * FROM movies ORDER BY fecha DESC",
            nativeQuery = true
    )
    List<Peliculas> getPeliculasOrderByDesc();
}
