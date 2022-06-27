package com.extrawest.currencyExchangeMicroservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CurrencyRateFromExchangerService {
    void saveCurrencyRates() throws JsonProcessingException;
}
