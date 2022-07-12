package com.extrawest.currencyExchangeMicroservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LimitResponseDTO {
    private int min;
    private int max;
}
