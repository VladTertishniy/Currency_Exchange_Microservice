package com.extrawest.currencyExchangeMicroservice.dto.request;

import lombok.Data;

@Data
public class CurrencyExchangeRequestDTO {
    private String currencyFrom;
    private String currencyTo;
    private double sum;
}
