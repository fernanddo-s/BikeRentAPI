package com.aluguelbicicleta.aluguelbicicleta.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "totens")
public class Totem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idTotem;
    
    @OneToMany(mappedBy = "totem", cascade = CascadeType.ALL)
    private List<Tranca> trancas;

    private String localizacao;
    private Integer capacidade;
    private String descricao;
}
