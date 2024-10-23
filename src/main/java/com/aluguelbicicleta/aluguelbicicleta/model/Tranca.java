package com.aluguelbicicleta.aluguelbicicleta.model;

import com.aluguelbicicleta.aluguelbicicleta.model.enums.StatusTranca;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trancas")
public class Tranca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "totem_id")
    private Totem totem;
    
    @OneToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicleta;

    private Integer numero;
    private String localizacao;
    private String anoFabricacao;
    private String modelo;
    
    @Enumerated(EnumType.STRING)
    private StatusTranca status;
}
