package com.extrawest.currencyExchangeMicroservice.model.dto;

import lombok.Data;

@Data
public class ExchangeRateEntityDTO {
    private ExchangeRateEntityIdDTO entityIdDTO;
    private double rate;
}
