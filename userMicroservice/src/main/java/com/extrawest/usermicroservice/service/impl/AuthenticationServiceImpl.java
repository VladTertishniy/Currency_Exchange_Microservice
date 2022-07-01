package com.extrawest.usermicroservice.service.impl;

import com.extrawest.usermicroservice.dto.request.UserRequestDTO;
import com.extrawest.usermicroservice.dto.response.UserResponseDTO;
import com.extrawest.usermicroservice.exception.ApiRequestException;
import com.extrawest.usermicroservice.mapper.UserMapper;
import com.extrawest.usermicroservice.model.User;
import com.extrawest.usermicroservice.repository.UserRepository;
import com.extrawest.usermicroservice.security.jwt.JwtTokenProvider;
import com.extrawest.usermicroservice.service.AuthenticationService;
import com.extrawest.usermicroservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    UserService userService;
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    JwtTokenProvider jwtTokenProvider;
    AuthenticationManager authenticationManager;

    @Override
    public UserResponseDTO register(UserRequestDTO userRequestDTO) {
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new ApiRequestException("Incorrect username or password!");
        }
        return create(userRequestDTO);
    }

    @Override
    public String login(String login, String password) throws AuthenticationException {
        User user = userService.getExistUser(login);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        String encodedPassword = passwordEncoder.encode(password);
        if (user.getPassword().equals(encodedPassword)) {
            throw new ApiRequestException("Incorrect username or password!");
        }
        return jwtTokenProvider.createToken(login, null);
    }

    private UserResponseDTO create(UserRequestDTO userRequestDTO) {
        User user = userMapper.toUserModel(userRequestDTO);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        return userMapper.toUserResponseDTO(userRepository.save(user));
    }
}
