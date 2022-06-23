package com.extrawest.limitsmicroservice.controller;

import com.extrawest.limitsmicroservice.dto.request.LimitRequestDTO;
import com.extrawest.limitsmicroservice.dto.response.LimitResponseDTO;
import com.extrawest.limitsmicroservice.service.LimitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/limits")
@AllArgsConstructor
public class LimitController {

    private final LimitService limitService;

    @PostMapping("/createLimit")
    public ResponseEntity<LimitResponseDTO> createLimit(@RequestBody @Valid LimitRequestDTO limitRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(limitService.createLimit(limitRequestDTO));
    }

    @PostMapping("/updateLimit/{id}")
    public ResponseEntity<LimitResponseDTO> updateLimit (@PathVariable Long id, @RequestBody @Valid LimitRequestDTO limitRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(limitService.updateLimit(id, limitRequestDTO));
    }

    @GetMapping("/deleteLimit/{id}")
    public void deleteUser (@PathVariable Long id) {
        limitService.deleteLimit(id);
    }

    @GetMapping("/getLimitById/{id}")
    public ResponseEntity<LimitResponseDTO> getLimitById (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(limitService.getLimitById(id));
    }

    @GetMapping("/getAllLimits")
    public ResponseEntity<List<LimitResponseDTO>> getAllUsers () {
        return ResponseEntity.status(HttpStatus.OK).body(limitService.getAllLimits());
    }

}
