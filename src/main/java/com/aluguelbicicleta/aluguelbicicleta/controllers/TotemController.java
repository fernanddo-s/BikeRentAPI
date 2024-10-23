package com.aluguelbicicleta.aluguelbicicleta.controllers;

import java.util.List;
import java.util.Optional;

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
import com.aluguelbicicleta.aluguelbicicleta.services.TotemService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/totem")
public class TotemController {

    @Autowired
    private TotemService totemService;

    @Transactional
    @GetMapping("/{id}")
    public Optional<Totem> findById(@PathVariable Long id){
        return totemService.findById(id);
    }

    @GetMapping
    public List<Totem> findAll(){
        return totemService.findAll();
    }

    @Transactional
    @PostMapping
    public Totem create(@RequestBody Totem t){
        return totemService.create(t);
    }

    @Transactional
    @PutMapping("/{id}")
    public Totem update(@PathVariable Long id, @RequestBody Totem t){
        return totemService.update(id, t);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        totemService.deleteById(id);
    }
}
