package com.extrawest.currencyExchangeMicroservice.dto;

import lombok.Data;

@Data
public class ExchangeRequestDTO {
    private String currencyFrom;
    private String currencyTo;
    private double sum;
}
