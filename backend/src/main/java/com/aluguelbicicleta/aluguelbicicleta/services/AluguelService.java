package com.aluguelbicicleta.aluguelbicicleta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluguelbicicleta.aluguelbicicleta.model.Aluguel;
import com.aluguelbicicleta.aluguelbicicleta.repository.AluguelRepository;

@Service
public class AluguelService {
    
    @Autowired
    private AluguelRepository aluguelRepository;

    public Optional<Aluguel> findById(Long id){
        return aluguelRepository.findById(id);
    }

    public List<Aluguel> findAll(){
        return aluguelRepository.findAll();
    }

    public Aluguel create(Aluguel a){
        //adicionar validações aqui/regras de negocio
        //verificar se existe a bicicleta e a tranca
        //verficar se as duas estão relacionadas
        // se tudo estiver correto realiza o aluguel
        return aluguelRepository.save(a);
    }

}
