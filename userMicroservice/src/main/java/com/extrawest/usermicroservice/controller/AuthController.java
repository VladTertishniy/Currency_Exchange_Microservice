package com.extrawest.usermicroservice.controller;

import com.extrawest.usermicroservice.dto.request.AuthRequestDTO;
import com.extrawest.usermicroservice.dto.request.UserRequestDTO;
import com.extrawest.usermicroservice.dto.response.UserResponseDTO;
import com.extrawest.usermicroservice.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class AuthController {

    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(userRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid AuthRequestDTO authRequestDTO) {
        String token = authenticationService.login(authRequestDTO.getEmail(), authRequestDTO.getPassword());
        Map<String, String> tokens = new HashMap<>();
        tokens.put("email", authRequestDTO.getEmail());
        tokens.put("token", token);
        return ResponseEntity.ok(tokens);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler logout = new SecurityContextLogoutHandler();
        logout.logout(request, response, null);
    }
}
