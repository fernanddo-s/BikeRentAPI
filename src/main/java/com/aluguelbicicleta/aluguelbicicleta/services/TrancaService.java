package com.aluguelbicicleta.aluguelbicicleta.services;

import java.util.List;
import java.util.Optional;

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

    public Optional<Tranca> findById(Long id){
        return trancaRepository.findById(id);
    }

    public List<Tranca> findAll(){
        return trancaRepository.findAll();
    }

    public Tranca update(Long id, Tranca t){
        Optional<Tranca> optionalTranca = trancaRepository.findById(id);

        if (optionalTranca.isPresent()) {
            Tranca trancaExistente = optionalTranca.get();
            //Verificar como trocar a tranca de totem e a bicicleta
            if(t.getNumero() != null){
                trancaExistente.setNumero(t.getNumero());
            }
            if(t.getLocalizacao() != null){
                trancaExistente.setLocalizacao(t.getLocalizacao());
            }
            if(t.getAnoFabricacao() != null){
                trancaExistente.setAnoFabricacao(t.getAnoFabricacao());
            }
            if(t.getModelo() != null){
                trancaExistente.setModelo(t.getModelo());
            }
            if(t.getStatus() != null){
                trancaExistente.setStatus(t.getStatus());
            }
            
            return trancaRepository.save(trancaExistente);
        } else {
            throw new RuntimeException("Bicicleta com ID " + id + " não encontrada");
        }
    }

    public void delete(Long id){
        trancaRepository.deleteById(id);
    }
}
