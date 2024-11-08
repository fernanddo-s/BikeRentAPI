package com.aluguelbicicleta.aluguelbicicleta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.aluguelbicicleta.aluguelbicicleta.model.Tranca;
import com.aluguelbicicleta.aluguelbicicleta.model.enums.StatusBicicleta;
import com.aluguelbicicleta.aluguelbicicleta.repository.BicicletaRepository;
import com.aluguelbicicleta.aluguelbicicleta.repository.TrancaRepository;

@Service
public class BicicletaService {

    @Autowired
    BicicletaRepository bicicletaRepository;

    @Autowired
    TrancaRepository trancaRepository;

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

    public ResponseEntity integrarNaRede(Long idTranca, Long idBicicleta){
        //recuperar as 2 entidades e verifica se pode fazer o relacionamento entre elas
        Optional<Bicicleta> optionalBicicleta = bicicletaRepository.findById(idBicicleta);
        Optional<Tranca> optionalTranca = trancaRepository.findById(idTranca);
        if(optionalBicicleta.isPresent() && optionalTranca.isPresent()){
            Bicicleta bicicletaExiste = optionalBicicleta.get();
            Tranca trancaExiste = optionalTranca.get();

            if(trancaExiste.getBicicleta() == null){
                trancaExiste.setBicicleta(bicicletaExiste);
            } else{
                return ResponseEntity.badRequest().build();
            }
            
            trancaRepository.save(trancaExiste);
            return ResponseEntity.ok().build();
        } else {
            throw new RuntimeException("Dados inválidos.");
        }
        
    }
}
