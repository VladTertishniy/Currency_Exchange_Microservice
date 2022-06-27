package com.extrawest.currencyExchangeMicroservice.model;


import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "exchangeRateEntity")
@Data
public class ExchangeRateEntity {
    @EmbeddedId
    private ExchangeRateEntityId id;
    private double rate;
}
