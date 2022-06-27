package com.extrawest.limitsmicroservice.controller;

import com.extrawest.limitsmicroservice.dto.response.LimitResponseDTO;
import com.extrawest.limitsmicroservice.service.LimitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/limits")
@AllArgsConstructor
public class LimitController {

    private final LimitService limitService;

    @GetMapping("/getLimit")
    public ResponseEntity<LimitResponseDTO> getLimit() {
        return ResponseEntity.status(HttpStatus.OK).body(limitService.getLimit());
    }
}
