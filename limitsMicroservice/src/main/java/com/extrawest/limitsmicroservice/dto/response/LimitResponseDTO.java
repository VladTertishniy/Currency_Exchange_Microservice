package com.extrawest.limitsmicroservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LimitResponseDTO {
    int min;
    int max;
}
