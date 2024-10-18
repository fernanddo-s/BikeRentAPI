package com.aluguelbicicleta.aluguelbicicleta.deserializer;

import com.aluguelbicicleta.aluguelbicicleta.model.Totem;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.UUID;

public class TotemDeserializer extends JsonDeserializer<Totem> {

    @Override
    public Totem deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        String uuid = jsonParser.getText();
        Totem totem = new Totem();
        totem.setId(UUID.fromString(uuid));
        return totem;
    }
}