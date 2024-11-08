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

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
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
    public Optional<Tranca> findById(@PathVariable Long id){
        return trancaService.findById(id);
    }

    @GetMapping
    public List<Tranca> findAll(){
        return trancaService.findAll();
    }

    @Transactional
    @PutMapping("/{id}")
    public Tranca update(@PathVariable Long id, @RequestBody Tranca t){
        return trancaService.update(id, t);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        trancaService.delete(id);
    }

    @GetMapping("/{id}/bicicleta")
    public Bicicleta findBicicletaByTrancaId(@PathVariable Long id){
        return trancaService.findBicicletaByTrancaId(id);
    }

    @Transactional
    @PostMapping("/{id}/trancar")
    public Tranca trancar(@PathVariable Long id){
        return trancaService.trancar(id);
    }

    @Transactional
    @PostMapping("/{id}/destrancar")
    public Tranca destrancar(@PathVariable Long id){
        return trancaService.destrancar(id);
    }

    @Transactional
    @PostMapping("/{id}/status/{acao}")
    public Tranca updateStatus(@PathVariable Long id, @PathVariable String acao){
        return trancaService.updateStatus(id, acao);
    }
}
