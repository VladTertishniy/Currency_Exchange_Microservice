package com.extrawest.currencyExchangeMicroservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        value = "exchangerBankFeignClient",
        url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5"
)
public interface ExchangerBankFeignClient {
    @GetMapping()
    String getCurrencyRates();
}
