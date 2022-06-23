package com.extrawest.currencyExchangeMicroservice.model;

import lombok.Data;

@Data
public class CurrencyExchangeEntity {
    private double buy;
    private double sale;
    private String ccy;
    private String base_ccy;
}
