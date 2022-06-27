package com.extrawest.currencyExchangeMicroservice.service.impl;

import com.extrawest.currencyExchangeMicroservice.feignClient.LimitsFeignClient;
import com.extrawest.currencyExchangeMicroservice.exception.ExchangingException;
import com.extrawest.currencyExchangeMicroservice.mapper.LimitMapper;
import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntity;
import com.extrawest.currencyExchangeMicroservice.model.ExchangeRateEntityId;
import com.extrawest.currencyExchangeMicroservice.model.Limit;
import com.extrawest.currencyExchangeMicroservice.repository.ExchangeRateRepository;
import com.extrawest.currencyExchangeMicroservice.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final LimitsFeignClient limitsFeignClient;
    private final ExchangeRateRepository exchangeRateRepository;
    private final LimitMapper limitMapper;

    @Override
    public Double exchange (String currencyFrom, String currencyTo, double sum) {
        ExchangeRateEntityId exchangeRateEntityId = new ExchangeRateEntityId(currencyFrom, currencyTo);
        ExchangeRateEntity exchangeRateEntity = exchangeRateRepository.getExchangeRateEntityById(exchangeRateEntityId);
        if (checkLimit(sum)){
            return sum * exchangeRateEntity.getRate();
        } throw new ExchangingException("Sum: " + sum + " not in limit");
    }

    private boolean checkLimit(double sum) {
        Limit limit = limitMapper.toLimitModel(limitsFeignClient.getLimit().getBody());
        return limit.getMin() < sum && limit.getMax() > sum;
    }
}
