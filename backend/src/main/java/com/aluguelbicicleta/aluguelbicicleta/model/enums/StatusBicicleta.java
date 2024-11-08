package com.aluguelbicicleta.aluguelbicicleta.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusBicicleta {
    DISPONIVEL, EM_USO, NOVA, APOSENTADA, REPARO_SOLICITADO, EM_REPARO;

    @JsonCreator
    public static StatusBicicleta fromString(String value) {
        return StatusBicicleta.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name().toUpperCase();
    }
}
