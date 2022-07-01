package com.extrawest.currencyExchangeMicroservice.feignClient;

import com.extrawest.currencyExchangeMicroservice.dto.response.LimitResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient( name = "limits-service"
        /*value = "limitsFeignClient",
        url = "http://localhost:8097",
        path = "/limits"*/
)
public interface LimitsFeignClient {
    @GetMapping("/getLimit")
    ResponseEntity<LimitResponseDTO> getLimit();
}
