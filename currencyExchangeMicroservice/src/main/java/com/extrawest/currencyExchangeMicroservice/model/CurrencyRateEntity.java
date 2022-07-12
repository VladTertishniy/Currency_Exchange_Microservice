package com.extrawest.currencyExchangeMicroservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class CurrencyRateEntity {
    private long id;
    private double sale;
    private double buy;
    @JsonProperty("ccy")
    private String currency;
    @JsonProperty("base_ccy")
    private String baseCurrency;
//    @JsonDeserialize(using = CurrenciesDeserializer.class)
//    private Enum<Currencies> currency;
//    @JsonDeserialize(using = CurrenciesDeserializer.class)
//    private Enum<Currencies> baseCurrency;
}
