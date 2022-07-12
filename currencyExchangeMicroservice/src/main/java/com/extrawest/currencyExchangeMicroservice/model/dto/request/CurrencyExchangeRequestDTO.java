package com.extrawest.currencyExchangeMicroservice.model.dto.request;

import com.extrawest.currencyExchangeMicroservice.model.Currencies;
import lombok.Data;

@Data
public class CurrencyExchangeRequestDTO {
    private String currencyFrom;
    private String currencyTo;
    private double sum;
}
