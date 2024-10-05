package com.aluguelbicicleta.aluguelbicicleta.model;

import java.util.UUID;

import com.aluguelbicicleta.aluguelbicicleta.model.enums.StatusBicicleta;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bicicletas")
public class Bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idBicicleta;

    @OneToOne
    @JoinColumn(name = "id_tranca", unique = true)
    private Tranca tranca;

    private Integer numero;
    private String marca;
    private String modelo;
    private String ano;

    @Enumerated(EnumType.STRING)
    private StatusBicicleta status;
}
