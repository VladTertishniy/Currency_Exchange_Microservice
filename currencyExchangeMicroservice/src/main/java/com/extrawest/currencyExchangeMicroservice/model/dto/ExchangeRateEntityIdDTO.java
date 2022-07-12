package com.extrawest.currencyExchangeMicroservice.model.dto;

import com.extrawest.currencyExchangeMicroservice.model.Currencies;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeRateEntityIdDTO {
    private String currencyFrom;
    private String currencyTo;
}
