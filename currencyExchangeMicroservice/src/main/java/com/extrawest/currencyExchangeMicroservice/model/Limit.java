package com.extrawest.currencyExchangeMicroservice.model;

import lombok.Data;

@Data
public class Limit {
    private int min;
    private int max;
}
