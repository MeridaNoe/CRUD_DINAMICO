package com.example.peliculas_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String director;
    private String duracion;
    private String genero;
    private Date fecha;
}
