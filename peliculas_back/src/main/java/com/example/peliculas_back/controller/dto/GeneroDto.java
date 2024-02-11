package com.example.peliculas_back.controller.dto;

import com.example.peliculas_back.model.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GeneroDto {

    private Long id;
    private String nombre;

    public Genero getGenero(){
        return new Genero(
                getId(),
                getNombre()
        );
    }
}
