package com.aluguelbicicleta.aluguelbicicleta.deserializer;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.aluguelbicicleta.aluguelbicicleta.model.enums.StatusBicicleta;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class BicicletaDeserializer extends JsonDeserializer<Bicicleta> {

    @Override
    public Bicicleta deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        Bicicleta bicicleta = new Bicicleta();

        if (node.isNumber()) {
            bicicleta.setId(node.asLong());
        }
        else if (node.isObject()) {
            if (node.has("id")) {
                bicicleta.setId(node.get("id").asLong());
            }
            if (node.has("numero")) {
                bicicleta.setNumero(node.get("numero").asInt());
            }
            if (node.has("marca")) {
                bicicleta.setMarca(node.get("marca").asText());
            }
            if (node.has("marca")) {
                bicicleta.setMarca(node.get("marca").asText());
            }
            if (node.has("modelo")) {
                bicicleta.setModelo(node.get("modelo").asText());
            }
            if (node.has("ano")) {
                bicicleta.setAno(node.get("ano").asText());
            }
            if (node.has("status")) {
                StatusBicicleta statusBicicleta = StatusBicicleta.valueOf(node.get("status").asText());
                bicicleta.setStatus(statusBicicleta);
            }
        }
        else {
            throw new IOException("Formato de entrada inválido para Totem.");
        }

        return bicicleta;
    }
}