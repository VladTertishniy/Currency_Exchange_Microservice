package com.extrawest.usermicroservice.service;

import com.extrawest.usermicroservice.dto.request.UserRequestDTO;
import com.extrawest.usermicroservice.dto.response.UserResponseDTO;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticationService {

    UserResponseDTO register(UserRequestDTO userRequestDto);

    String login(String login, String password) throws AuthenticationException;
}
