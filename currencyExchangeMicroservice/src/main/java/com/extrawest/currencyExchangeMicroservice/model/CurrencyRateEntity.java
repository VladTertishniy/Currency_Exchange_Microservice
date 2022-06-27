package com.extrawest.currencyExchangeMicroservice.model;

import lombok.Data;

@Data
public class CurrencyRateEntity {
    private long id;
    private double sale;
    private double buy;
    private String ccy;
    private String base_ccy;
}
