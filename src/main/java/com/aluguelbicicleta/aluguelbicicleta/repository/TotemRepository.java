package com.aluguelbicicleta.aluguelbicicleta.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluguelbicicleta.aluguelbicicleta.model.Totem;

public interface TotemRepository extends JpaRepository<Totem, UUID>{
    
    //implementar o update
    // private Totem update(UUID id, Totem t){
        
    // }
}
