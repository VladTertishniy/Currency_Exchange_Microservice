package com.extrawest.currencyExchangeMicroservice.controller;

import com.extrawest.currencyExchangeMicroservice.dto.request.CurrencyExchangeRequestDTO;
import com.extrawest.currencyExchangeMicroservice.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchangeCurrency")
@AllArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @PostMapping
    public ResponseEntity<Double> exchange(@RequestBody @Valid CurrencyExchangeRequestDTO currencyExchangeRequestDTO) {
        return ResponseEntity.ok(currencyExchangeService.exchange(currencyExchangeRequestDTO.getCurrencyFrom(),
                currencyExchangeRequestDTO.getCurrencyTo(), currencyExchangeRequestDTO.getSum()));
    }
}
