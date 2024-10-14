package com.aluguelbicicleta.aluguelbicicleta.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluguelbicicleta.aluguelbicicleta.model.Totem;
import com.aluguelbicicleta.aluguelbicicleta.repository.TotemRepository;

@Service
public class TotemService {
    
    @Autowired
    private TotemRepository totemRepository;

    public Totem update(UUID id, Totem t){
        Optional<Totem> totem = totemRepository.findById(id);
        if(totem.isPresent()){
            return totemRepository.save(t);
        }
        return null;
    }
}
