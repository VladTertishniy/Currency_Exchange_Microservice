package com.extrawest.currencyExchangeMicroservice.service;

public interface CurrencyExchangeService {
    Double exchange(String currencyFrom, String currencyTo, double sum);
}
