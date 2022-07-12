package com.extrawest.currencyExchangeMicroservice.model.mapper;

import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntity;
import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntityId;
import com.extrawest.currencyExchangeMicroservice.model.dto.ExchangeRateEntityDTO;
import com.extrawest.currencyExchangeMicroservice.model.dto.ExchangeRateEntityIdDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExchangeRateEntityMapper {
    ExchangeRateEntityDTO toExchangeRateEntityDTO(ExchangeRateEntity entity);
    @Mapping(source = "dto.entityIdDTO", target = "id")
    ExchangeRateEntity toExchangeRateEntity(ExchangeRateEntityDTO dto);

    ExchangeRateEntityIdDTO toExchangeRateEntityIdDTO(ExchangeRateEntityId entity);
    ExchangeRateEntityId toExchangeRateEntityId(ExchangeRateEntityIdDTO dto);
}
