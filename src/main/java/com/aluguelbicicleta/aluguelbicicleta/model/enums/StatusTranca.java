package com.aluguelbicicleta.aluguelbicicleta.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusTranca {
    LIVRE, OCUPADA, NOVA, APOSENTADA, EM_REPARO;

    @JsonCreator
    public static StatusTranca fromString(String value) {
        return StatusTranca.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name().toUpperCase();
    }
}
