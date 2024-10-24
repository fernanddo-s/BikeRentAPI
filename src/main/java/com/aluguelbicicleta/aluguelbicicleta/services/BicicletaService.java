package com.aluguelbicicleta.aluguelbicicleta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.aluguelbicicleta.aluguelbicicleta.model.enums.StatusBicicleta;
import com.aluguelbicicleta.aluguelbicicleta.repository.BicicletaRepository;

@Service
public class BicicletaService {

    @Autowired
    BicicletaRepository bicicletaRepository;

    public Optional<Bicicleta> findById(Long id){
        return bicicletaRepository.findById(id);
    }

    public List<Bicicleta> findAll(){
        return bicicletaRepository.findAll();
    }

    public Bicicleta create(Bicicleta b){
        return bicicletaRepository.save(b);
    }

    public Bicicleta update(Long id, Bicicleta b){
        Optional<Bicicleta> optionalBicicleta = bicicletaRepository.findById(id);

        if (optionalBicicleta.isPresent()) {
            Bicicleta bicicletaExiste = optionalBicicleta.get();
            if(b.getTranca() != null){
                bicicletaExiste.setTranca(b.getTranca());
            }
            if(b.getNumero() != null){
                bicicletaExiste.setNumero(b.getNumero());
            }
            if (b.getMarca() != null) {
                bicicletaExiste.setMarca(b.getMarca());
            }
            if(b.getModelo() != null){
                bicicletaExiste.setModelo(b.getModelo());
            }
            if(b.getAno() != null){
                bicicletaExiste.setAno(b.getAno());
            }
            if(b.getStatus() != null){
                bicicletaExiste.setStatus(b.getStatus());
            }
            
            return bicicletaRepository.save(bicicletaExiste);
        } else {
            throw new RuntimeException("Bicicleta com ID " + id + " não encontrada");
        }
    }

    public void delete(Long id){
        bicicletaRepository.deleteById(id);
    }

    public Bicicleta updateStatus(Long id, String acao){
        Optional<Bicicleta> optionalBicicleta = bicicletaRepository.findById(id);
        if(optionalBicicleta.isPresent()){
            Bicicleta bicicletaExiste = optionalBicicleta.get();
            if(acao != null){
                StatusBicicleta statusBicicleta = StatusBicicleta.valueOf(acao.toUpperCase());
                bicicletaExiste.setStatus(statusBicicleta);
            }
            
            return bicicletaRepository.save(bicicletaExiste);
        } else {
            throw new RuntimeException("Bicicleta com ID " + id + " não encontrada");
        }
    }
}
