package com.aluguelbicicleta.aluguelbicicleta.controllers;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.aluguelbicicleta.aluguelbicicleta.repository.BicicletaRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {
    
    @Autowired
    private BicicletaRepository bicicletaRepository;

    @GetMapping
    public List<Bicicleta> findAll(){
        return bicicletaRepository.findAll();
    }

    @Transactional
    @GetMapping("/{id}")
    public Optional<Bicicleta> findById(@PathVariable UUID id){
        return bicicletaRepository.findById(id);
    }

    @Transactional
    @PostMapping
    public Bicicleta create(@RequestBody Bicicleta b){
        return bicicletaRepository.save(b);
    }
}
