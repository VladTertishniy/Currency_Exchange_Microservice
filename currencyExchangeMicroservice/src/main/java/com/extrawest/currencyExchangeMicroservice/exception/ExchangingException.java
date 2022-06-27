package com.extrawest.currencyExchangeMicroservice.exception;

public class ExchangingException extends RuntimeException{
    public ExchangingException(String message) {
        super(message);
    }
}
