package com.example.peliculas_back.repository;

import com.example.peliculas_back.model.Genero;
import com.example.peliculas_back.model.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface PeliculasRepo extends JpaRepository<Peliculas, Long> {


}
