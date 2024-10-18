package com.aluguelbicicleta.aluguelbicicleta.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.aluguelbicicleta.aluguelbicicleta.model.Totem;
import com.aluguelbicicleta.aluguelbicicleta.model.Tranca;
import com.aluguelbicicleta.aluguelbicicleta.repository.BicicletaRepository;
import com.aluguelbicicleta.aluguelbicicleta.repository.TotemRepository;
import com.aluguelbicicleta.aluguelbicicleta.repository.TrancaRepository;

@Service
public class TrancaService {
    
    @Autowired
    TrancaRepository trancaRepository;

    @Autowired
    TotemRepository totemRepository;

    @Autowired
    BicicletaRepository bicicletaRepository;

    public Tranca create(Tranca t){
        Totem totem = totemRepository.findById(t.getTotem().getId()).get();
        Bicicleta bicicleta = bicicletaRepository.findById(t.getBicicleta().getId()).get();
        t.setTotem(totem);
        t.setBicicleta(bicicleta);
        return trancaRepository.save(t);
    }

    public Optional<Tranca> findById(UUID id){
        return trancaRepository.findById(id);
    }

    public List<Tranca> findAll(){
        return trancaRepository.findAll();
    }

    public Tranca update(Tranca t){
        return trancaRepository.save(t);
    }

    public void delete(UUID id){
        trancaRepository.deleteById(id);
    }
}
