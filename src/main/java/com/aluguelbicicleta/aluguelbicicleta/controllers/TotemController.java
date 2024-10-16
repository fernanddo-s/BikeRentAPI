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

import com.aluguelbicicleta.aluguelbicicleta.model.Totem;
import com.aluguelbicicleta.aluguelbicicleta.repository.TotemRepository;
import com.aluguelbicicleta.aluguelbicicleta.services.TotemService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/totem")
public class TotemController {
    
    @Autowired
    private TotemRepository totemRepository;

    @Autowired
    private TotemService totemService;

    @Transactional
    @GetMapping("/{id}")
    public Optional<Totem> findById(@PathVariable UUID id){
        return totemRepository.findById(id);
    }

    @GetMapping
    public List<Totem> findAll(){
        return totemRepository.findAll();
    }

    @Transactional
    @PostMapping
    public Totem create(@RequestBody Totem t){
        return totemRepository.save(t);
    }

    @Transactional
    @PutMapping
    public Totem update(@RequestBody Totem t){
        return totemService.update(t);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        totemRepository.deleteById(id);
    }
}
