package com.example.peliculas_back.controller;


import com.example.peliculas_back.controller.dto.PeliculasDto;
import com.example.peliculas_back.model.Genero;
import com.example.peliculas_back.model.Peliculas;
import com.example.peliculas_back.service.GeneroService;
import com.example.peliculas_back.service.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "http://localhost:5173")
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


    //GET PELICULAS CON NOMBRE CLAVE
    @GetMapping("/nombre/{nombre}")
    public List<Peliculas> getPeliculasNombre(@PathVariable String nombre) {
        return service.getPeliculasByNombre(nombre);
    }

    @GetMapping("/director/{director}")
    public List<Peliculas> getPeliculasDirector(@PathVariable String director) {
        return service.getPeliculasByDirector(director);
    }
    @GetMapping("/buscarFechas")
    public List<Peliculas> findByDates(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicioConvertida = format.parse(fechaInicio);
        Date fechaFinConvertida = format.parse(fechaFin);
        return service.buscarPorFechas(fechaInicioConvertida, fechaFinConvertida);
    }

    @GetMapping("/buscarGenero")
    public List<Peliculas> findByCategory(@RequestParam String genero){
        return service.findByCategory(genero);
    }

    @GetMapping("/orderDesc")
    public List<Peliculas> getPelicuasDesc(){
        return service.getPeliculasOrderByDesc();
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
