package com.extrawest.usermicroservice.service;

import com.extrawest.usermicroservice.dto.request.UserRequestDTO;
import com.extrawest.usermicroservice.dto.response.UserResponseDTO;
import com.extrawest.usermicroservice.model.User;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);

    User getExistUser(String email);
}
