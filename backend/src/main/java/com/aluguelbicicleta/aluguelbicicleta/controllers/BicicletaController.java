package com.aluguelbicicleta.aluguelbicicleta.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.aluguelbicicleta.aluguelbicicleta.services.BicicletaService;

// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.responses.ApiResponses;
// import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/bicicleta", produces = {"application/json"})
// @Tag(name = "bicicleta")
public class BicicletaController {
    
    @Autowired
    private BicicletaService bicicletaService;

    @GetMapping
    // @Operation(summary = "Busca todas as bicicletas", method = "GET")
    // @ApiResponses(value = {
    //     @ApiResponse(responseCode = "200", description = "Lista de bicicletas"),
    // })
    public List<Bicicleta> findAll(){
        return bicicletaService.findAll();
    }

    @Transactional
    @GetMapping("/{id}")
    public Optional<Bicicleta> findById(@PathVariable Long id){
        return bicicletaService.findById(id);
    }

    @Transactional
    @PostMapping
    public Bicicleta create(@RequestBody Bicicleta b){
        return bicicletaService.create(b);
    }

    @Transactional
    @PutMapping("/{id}")
    public Bicicleta update(@PathVariable Long id, @RequestBody Bicicleta b){
        return bicicletaService.update(id, b);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bicicletaService.delete(id);
    }

    @Transactional
    @PostMapping("/{id}/status/{acao}")
    public Bicicleta updateStatus(@PathVariable Long id, @PathVariable String acao){
        return bicicletaService.updateStatus(id, acao);
    }

    @PostMapping("/integrarNaRede")
    public ResponseEntity integrarNaRede(@RequestBody Long idTranca, @RequestBody Long idBicicleta){
        return bicicletaService.integrarNaRede(idTranca, idBicicleta);
    }
}
