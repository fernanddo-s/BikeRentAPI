package com.aluguelbicicleta.aluguelbicicleta.deserializer;

import com.aluguelbicicleta.aluguelbicicleta.model.Totem;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class TotemDeserializer extends JsonDeserializer<Totem> {

    @Override
    public Totem deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        Totem totem = new Totem();

        if (node.isNumber()) {
            totem.setId(node.asLong());
        }
        else if (node.isObject()) {
            if (node.has("id")) {
                totem.setId(node.get("id").asLong());
            }
            if (node.has("localizacao")) {
                totem.setLocalizacao(node.get("localizacao").asText());
            }
            if (node.has("capacidade")) {
                totem.setCapacidade(node.get("capacidade").asInt());
            }
            if (node.has("descricao")) {
                totem.setDescricao(node.get("descricao").asText());
            }
        }
        else {
            throw new IOException("Formato de entrada inválido para Totem.");
        }

        return totem;
    }
}