package com.extrawest.limitsmicroservice.service.impl;

import com.extrawest.limitsmicroservice.dto.response.LimitResponseDTO;
import com.extrawest.limitsmicroservice.service.LimitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LimitServiceImpl implements LimitService {

    @Value("${limit.min}")
    private int min;
    @Value("${limit.max}")
    private int max;

    @Override
    public LimitResponseDTO getLimit() {
        return new LimitResponseDTO(min, max);
    }

}
