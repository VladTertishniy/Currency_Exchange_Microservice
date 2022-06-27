package com.extrawest.currencyExchangeMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ExchangeRateEntityId implements Serializable {
    private String currencyFrom;
    private String currencyTo;

}
