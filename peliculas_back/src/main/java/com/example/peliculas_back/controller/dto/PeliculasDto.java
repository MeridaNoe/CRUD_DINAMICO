package com.example.peliculas_back.controller.dto;

import com.example.peliculas_back.model.Genero;
import com.example.peliculas_back.model.Peliculas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PeliculasDto {

    private Long id;
    private String nombre;
    private String director;
    private String duracion;
    private String genero;

    public Peliculas  getPeliculas(){
        return new Peliculas(
                getId(),
                getNombre(),
                getDirector(),
                getDuracion(),
                getGenero()
        );
    }
}
