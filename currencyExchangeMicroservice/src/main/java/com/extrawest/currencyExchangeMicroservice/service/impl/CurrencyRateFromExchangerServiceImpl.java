package com.extrawest.currencyExchangeMicroservice.service.impl;

import com.extrawest.currencyExchangeMicroservice.feignClient.ExchangerBankFeignClient;
import com.extrawest.currencyExchangeMicroservice.model.CurrencyRateEntity;
import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntity;
import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntityId;
import com.extrawest.currencyExchangeMicroservice.repository.ExchangeRateRepository;
import com.extrawest.currencyExchangeMicroservice.service.CurrencyRateFromExchangerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CurrencyRateFromExchangerServiceImpl implements CurrencyRateFromExchangerService {

    private final ExchangerBankFeignClient exchangerBankFeignClient;
    private final ExchangeRateRepository exchangeRateRepository;

    @PostConstruct
    @Scheduled(cron = "@hourly")
    @Override
    public void saveCurrencyRates() throws JsonProcessingException {
        log.debug("start");
        List<CurrencyRateEntity> currencyRateEntityList = mapResult(exchangerBankFeignClient.getCurrencyRates());
        log.debug("result " + currencyRateEntityList.stream().toList());
        exchangeRateRepository.deleteAll();
        for (CurrencyRateEntity currencyRateEntity : currencyRateEntityList) {

            ExchangeRateEntityId baseToCcyId = new ExchangeRateEntityId();
            baseToCcyId.setCurrencyFrom(currencyRateEntity.getBase_ccy());
            baseToCcyId.setCurrencyTo(currencyRateEntity.getCcy());
            ExchangeRateEntity baseToCcy = new ExchangeRateEntity();
            baseToCcy.setId(baseToCcyId);
            baseToCcy.setRate(currencyRateEntity.getBuy());

            ExchangeRateEntityId ccyToBaseId = new ExchangeRateEntityId();
            ccyToBaseId.setCurrencyFrom(currencyRateEntity.getCcy());
            ccyToBaseId.setCurrencyTo(currencyRateEntity.getBase_ccy());
            ExchangeRateEntity ccyToBase = new ExchangeRateEntity();
            ccyToBase.setId(ccyToBaseId);
            ccyToBase.setRate(currencyRateEntity.getSale());

            exchangeRateRepository.save(baseToCcy);
            exchangeRateRepository.save(ccyToBase);
        }
    }

    private List<CurrencyRateEntity> mapResult(String result) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(result, new TypeReference<>() {});
    }
}
