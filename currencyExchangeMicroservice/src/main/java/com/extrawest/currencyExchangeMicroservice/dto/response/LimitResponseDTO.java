package com.extrawest.currencyExchangeMicroservice.dto.response;

import lombok.Data;

@Data
public class LimitResponseDTO {
    private int min;
    private int max;
}
