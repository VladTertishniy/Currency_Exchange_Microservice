package com.extrawest.currencyExchangeMicroservice.model.mapper;

import com.extrawest.currencyExchangeMicroservice.model.dto.response.LimitResponseDTO;
import com.extrawest.currencyExchangeMicroservice.model.Limit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LimitMapper {
    Limit toLimitModel(LimitResponseDTO limitResponseDTO);
}
