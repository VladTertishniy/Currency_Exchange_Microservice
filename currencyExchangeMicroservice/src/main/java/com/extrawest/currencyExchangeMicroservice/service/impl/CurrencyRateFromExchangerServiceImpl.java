package com.extrawest.currencyExchangeMicroservice.service.impl;

import com.extrawest.currencyExchangeMicroservice.feignClient.ExchangerBankFeignClient;
import com.extrawest.currencyExchangeMicroservice.model.Currencies;
import com.extrawest.currencyExchangeMicroservice.model.CurrencyRateEntity;
import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntity;
import com.extrawest.currencyExchangeMicroservice.model.dto.ExchangeRateEntityDTO;
import com.extrawest.currencyExchangeMicroservice.model.dto.ExchangeRateEntityIdDTO;
import com.extrawest.currencyExchangeMicroservice.model.mapper.ExchangeRateEntityMapper;
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
    private final ExchangeRateEntityMapper exchangeRateEntityMapper;

    @PostConstruct
    @Scheduled(cron = "@hourly")
    @Override
    public void saveCurrencyRates() throws JsonProcessingException {
        log.debug("start");
        List<CurrencyRateEntity> currencyRateEntityList = mapResult(exchangerBankFeignClient.getCurrencyRates());
        log.debug("result " + currencyRateEntityList.stream().toList());
        exchangeRateRepository.deleteAll();

//        Enum<Currencies> currency;
//        Enum<Currencies> baseCurrency;
        String currency;
        String baseCurrency;
        double sale;
        double buy;
        for (CurrencyRateEntity currencyRateEntity : currencyRateEntityList) {
            currency = currencyRateEntity.getCurrency();
            baseCurrency = currencyRateEntity.getBaseCurrency();
            sale = currencyRateEntity.getSale();
            buy = currencyRateEntity.getBuy();

            ExchangeRateEntityDTO baseToCurrencyDTO = new ExchangeRateEntityDTO();
            baseToCurrencyDTO.setEntityIdDTO(new ExchangeRateEntityIdDTO(baseCurrency, currency));
            baseToCurrencyDTO.setRate(1/sale);
            ExchangeRateEntity baseToCurrencyEntity = exchangeRateEntityMapper.toExchangeRateEntity(baseToCurrencyDTO);

            ExchangeRateEntityDTO currencyToBaseDTO = new ExchangeRateEntityDTO();
            currencyToBaseDTO.setEntityIdDTO(new ExchangeRateEntityIdDTO(currency, baseCurrency));
            currencyToBaseDTO.setRate(buy);
            ExchangeRateEntity currencyToBaseEntity = exchangeRateEntityMapper.toExchangeRateEntity(currencyToBaseDTO);
//            ExchangeRateEntityId baseToCcyId = new ExchangeRateEntityId();
//            baseToCcyId.setCurrencyFrom(currencyRateEntity.getBaseCurrency());
//            baseToCcyId.setCurrencyTo(currencyRateEntity.getCurrency());
//            ExchangeRateEntity baseToCcy = new ExchangeRateEntity();
//            baseToCcy.setId(baseToCcyId);
//            baseToCcy.setRate(currencyRateEntity.getBuy());
//            /*base = UAH, ccy = USD, sale = 35, buy = 34*/
//            ExchangeRateEntityId ccyToBaseId = new ExchangeRateEntityId();
//            ccyToBaseId.setCurrencyFrom(currencyRateEntity.getCurrency());
//            ccyToBaseId.setCurrencyTo(currencyRateEntity.getBaseCurrency());
//            ExchangeRateEntity ccyToBase = new ExchangeRateEntity();
//            ccyToBase.setId(ccyToBaseId);
//            ccyToBase.setRate(currencyRateEntity.getSale());

            exchangeRateRepository.save(baseToCurrencyEntity);
            exchangeRateRepository.save(currencyToBaseEntity);
        }
    }

    private List<CurrencyRateEntity> mapResult(String result) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(result, new TypeReference<>() {});
    }
}
