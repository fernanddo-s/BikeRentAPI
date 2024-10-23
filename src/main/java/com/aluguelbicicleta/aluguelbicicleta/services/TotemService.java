package com.aluguelbicicleta.aluguelbicicleta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluguelbicicleta.aluguelbicicleta.model.Totem;
import com.aluguelbicicleta.aluguelbicicleta.repository.TotemRepository;

@Service
public class TotemService {
    
    @Autowired
    private TotemRepository totemRepository;

    public Totem create(Totem t){
        return totemRepository.save(t);
    }

    public Optional<Totem> findById(Long id){
        return totemRepository.findById(id);
    }

    public List<Totem> findAll(){
        return totemRepository.findAll();
    }

    public Totem update(Long id, Totem t){
        Optional<Totem> optionalTotem = totemRepository.findById(id);

        if (optionalTotem.isPresent()) {
            Totem totemExistente = optionalTotem.get();
            if(t.getCapacidade() != null){
                totemExistente.setCapacidade(t.getCapacidade());
            }
            if(t.getDescricao() != null){
                totemExistente.setDescricao(t.getDescricao());
            }
            if(t.getLocalizacao() != null){
                totemExistente.setLocalizacao(t.getLocalizacao());
            }
            
            return totemRepository.save(totemExistente);
        } else {
            throw new RuntimeException("Bicicleta com ID " + id + " não encontrada");
        }
    }

    public void deleteById(Long id){
        totemRepository.deleteById(id);
    }
}
