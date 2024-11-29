package com.aluguelbicicleta.aluguelbicicleta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluguelbicicleta.aluguelbicicleta.model.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
    
}
