package com.aluguelbicicleta.aluguelbicicleta.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluguelbicicleta.aluguelbicicleta.model.Tranca;
import com.aluguelbicicleta.aluguelbicicleta.services.TrancaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/tranca")
public class TrancaController {

    @Autowired
    TrancaService trancaService;
    
    @Transactional
    @PostMapping
    public Tranca create(@RequestBody Tranca t){
        return trancaService.create(t);
    }

    @GetMapping("/{id}")
    public Optional<Tranca> findById(@PathVariable UUID id){
        return trancaService.findById(id);
    }

    @GetMapping
    public List<Tranca> findAll(){
        return trancaService.findAll();
    }

    @PutMapping
    @Transactional
    public Tranca update(@RequestBody Tranca t){
        return trancaService.update(t);
    }

    @DeleteMapping
    @Transactional
    public void delete(@PathVariable UUID id){
        trancaService.delete(id);
    }
}
