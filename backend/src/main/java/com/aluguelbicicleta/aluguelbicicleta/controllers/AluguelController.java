 package com.aluguelbicicleta.aluguelbicicleta.controllers;

 import java.util.List;
 import java.util.Optional;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import com.aluguelbicicleta.aluguelbicicleta.model.Aluguel;
 import com.aluguelbicicleta.aluguelbicicleta.services.AluguelService;

 import jakarta.transaction.Transactional;

 @RestController
 @RequestMapping("/aluguel")
 public class AluguelController {

     @Autowired
     private AluguelService aluguelService;

     @GetMapping
     public List<Aluguel> findAll(){
         return aluguelService.findAll();
     }

     @Transactional
     @GetMapping("/{id}")
     public Optional<Aluguel> findById(@PathVariable Long id){
         return aluguelService.findById(id);
     }

     @Transactional
     @PostMapping
     public Aluguel create(@RequestBody Aluguel b){
         return aluguelService.create(b);
     }
    
 }
