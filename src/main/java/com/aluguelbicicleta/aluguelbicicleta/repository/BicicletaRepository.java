package com.aluguelbicicleta.aluguelbicicleta.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, UUID>{
    
}
