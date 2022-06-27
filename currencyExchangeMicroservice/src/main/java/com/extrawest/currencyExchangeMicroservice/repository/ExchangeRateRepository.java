package com.extrawest.currencyExchangeMicroservice.repository;

import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntity;
import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {
    ExchangeRateEntity getExchangeRateEntityById(ExchangeRateEntityId id);
}
