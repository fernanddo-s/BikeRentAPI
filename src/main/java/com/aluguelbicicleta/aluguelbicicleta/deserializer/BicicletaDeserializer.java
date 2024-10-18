package com.aluguelbicicleta.aluguelbicicleta.deserializer;

import com.aluguelbicicleta.aluguelbicicleta.model.Bicicleta;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.UUID;

public class BicicletaDeserializer extends JsonDeserializer<Bicicleta> {

    @Override
    public Bicicleta deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        String uuid = jsonParser.getText();
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setId(UUID.fromString(uuid));
        return bicicleta;
    }
}