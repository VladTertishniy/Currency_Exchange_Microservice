package com.extrawest.limitsmicroservice.mapper;

import com.extrawest.limitsmicroservice.dto.request.LimitRequestDTO;
import com.extrawest.limitsmicroservice.dto.response.LimitResponseDTO;
import com.extrawest.limitsmicroservice.model.Limit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LimitMapper {
    LimitResponseDTO toResponseDTO(Limit limit);
    LimitRequestDTO toRequestDTO(Limit limit);
    Limit toLimitModel(LimitResponseDTO limitResponseDTO);
    Limit toLimitModel(LimitRequestDTO limitRequestDTO);
}
