package com.example.peliculas_back.service;

import com.example.peliculas_back.model.Genero;
import com.example.peliculas_back.model.Peliculas;
import com.example.peliculas_back.repository.PeliculasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PeliculasService {
    @Autowired
    private PeliculasRepo repo;

    public List<Peliculas> getListPeliculas() {
        return repo.findAll();
    }


    public Optional<Peliculas> getById(Long id) {
        return repo.findById(id);
    }

    public Peliculas insertPeli(Peliculas peliculas) {
        return repo.save(peliculas);
    }

    public void deletePeli (Long id) {
        repo.deleteById(id);
    }

    public Peliculas updatePeli (Peliculas peliculas){
        return repo.saveAndFlush(peliculas);
    }
}
