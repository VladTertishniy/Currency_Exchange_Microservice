package com.extrawest.currencyExchangeMicroservice.feignClient;

import com.extrawest.currencyExchangeMicroservice.model.dto.response.LimitResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "limits-service")
public interface LimitsFeignClient {
    @GetMapping("/getLimit")
    @Retry(name="limits-service")
    @CircuitBreaker(name="limits-service", fallbackMethod = "getFallback")
    ResponseEntity<LimitResponseDTO> getLimit();

    default ResponseEntity<LimitResponseDTO> getFallback(Exception e) {
        return ResponseEntity.ok().body(new LimitResponseDTO(0, 1000));
    }
}
