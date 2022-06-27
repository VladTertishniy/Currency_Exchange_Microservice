package com.extrawest.limitsmicroservice.service;

import com.extrawest.limitsmicroservice.dto.request.LimitRequestDTO;
import com.extrawest.limitsmicroservice.dto.response.LimitResponseDTO;

import java.util.List;

public interface LimitService {
    LimitResponseDTO getLimit();
    /*LimitResponseDTO createLimit(LimitRequestDTO limitRequestDTO);
    void deleteLimit(Long id);
    LimitResponseDTO updateLimit(Long id, LimitRequestDTO limitRequestDTO);
    List<LimitResponseDTO> getAllLimits();
    LimitResponseDTO getLimitById(Long id);*/
}
