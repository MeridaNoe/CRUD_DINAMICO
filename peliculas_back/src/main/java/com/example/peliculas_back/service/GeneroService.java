package com.example.peliculas_back.service;

import com.example.peliculas_back.model.Genero;
import com.example.peliculas_back.repository.GeneroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepo repo;
    public Set<String> getNombreGenero(){
        return repo.findAllGenero();
    }

}
