package com.example.peliculas_back.controller;


import com.example.peliculas_back.controller.dto.PeliculasDto;
import com.example.peliculas_back.model.Genero;
import com.example.peliculas_back.model.Peliculas;
import com.example.peliculas_back.service.GeneroService;
import com.example.peliculas_back.service.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class PeliculasController {
    @Autowired
    private PeliculasService service;

    @Autowired
    private GeneroService generoService;

    @GetMapping("/")
    public List<Peliculas> getAll(){
        return service.getListPeliculas();
    }

    @GetMapping("/{id}")
    public Peliculas getIdPelicula(@PathVariable Long id){
        return service.getById(id).orElse(null);
    }

    @GetMapping("/genero")
    public Set<String> getGenero(){
        return generoService.getNombreGenero();
    }

    @PostMapping("/")
    public Peliculas insertpelicula(@RequestBody PeliculasDto peliculasDto){
        return service.insertPeli(peliculasDto.getPeliculas());
    }

    @DeleteMapping("/")
    public void deletePeliculas(@PathVariable Long id){
        service.deletePeli(id);
    }
}
