package com.extrawest.currencyExchangeMicroservice.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.Data;

import java.io.IOException;
import java.util.Objects;

public class CurrenciesDeserializer extends StdDeserializer<Currencies> {
    protected CurrenciesDeserializer(Class<?> vc) {
        super(vc);
    }

    protected CurrenciesDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected CurrenciesDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Currencies deserialize(JsonParser jsonParser, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String ccy = node.get("ccy").asText();
        String base_ccy = node.get("base_ccy").asText();

        for (Currencies currency : Currencies.values()) {

            if (Objects.equals(currency.getCurrencyName(), ccy) || Objects.equals(currency.getCurrencyName(), base_ccy)) {
                return currency;
            }
        }

        return null;
    }
}
