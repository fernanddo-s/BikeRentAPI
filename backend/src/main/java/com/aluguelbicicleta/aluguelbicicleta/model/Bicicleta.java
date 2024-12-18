package com.aluguelbicicleta.aluguelbicicleta.model;

import com.aluguelbicicleta.aluguelbicicleta.deserializer.BicicletaDeserializer;
import com.aluguelbicicleta.aluguelbicicleta.model.enums.StatusBicicleta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@JsonDeserialize(using = BicicletaDeserializer.class)
public class Bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "bicicleta", cascade = CascadeType.ALL)
    @JsonIgnore
    private Tranca tranca;

    @NonNull
    @Column(unique = true)
    private Integer numero;
    private String marca;
    private String modelo;
    private String ano;

    @Enumerated(EnumType.STRING)
    private StatusBicicleta status;
}
