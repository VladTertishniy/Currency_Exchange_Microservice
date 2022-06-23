package com.extrawest.limitsmicroservice.dto.request;

import lombok.Data;

@Data
public class LimitRequestDTO {
    int min;
    int max;
}
