package com.extrawest.usermicroservice.exception;

public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }
}
