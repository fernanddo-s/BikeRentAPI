package com.aluguelbicicleta.aluguelbicicleta.model;

import java.util.List;

import com.aluguelbicicleta.aluguelbicicleta.deserializer.TotemDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
@JsonDeserialize(using = TotemDeserializer.class)
public class Totem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "totem", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tranca> trancas;

    private String localizacao;
    private Integer capacidade;
    private String descricao;

    @JsonCreator
    public Totem(@JsonProperty("id") Long id) {
        this.id = id;
    }
}
