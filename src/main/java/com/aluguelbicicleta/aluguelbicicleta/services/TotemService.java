package com.aluguelbicicleta.aluguelbicicleta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluguelbicicleta.aluguelbicicleta.model.Totem;
import com.aluguelbicicleta.aluguelbicicleta.repository.TotemRepository;

@Service
public class TotemService {
    
    @Autowired
    private TotemRepository totemRepository;

    public Totem update(Totem t){
        var totem = totemRepository.findById(t.getId());
        if(totem.isPresent()){
            return totemRepository.save(t);
        }
        return null;
    }
}
