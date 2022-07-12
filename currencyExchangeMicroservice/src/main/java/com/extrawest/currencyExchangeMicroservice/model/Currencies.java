package com.extrawest.currencyExchangeMicroservice.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonDeserialize(using = CurrenciesDeserializer.class)
public enum Currencies {
    UAH("UAH"),
    USD("USD"),
    EUR("EUR"),
    BTC("BTC");

    private final String currencyName;

    Currencies(String currencyName) {
        this.currencyName = currencyName;
    }

    @JsonValue
    public String getCurrencyName() {
        return this.currencyName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
