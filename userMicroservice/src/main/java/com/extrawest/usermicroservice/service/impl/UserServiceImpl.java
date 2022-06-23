package com.extrawest.usermicroservice.service.impl;

import com.extrawest.usermicroservice.dto.request.UserRequestDTO;
import com.extrawest.usermicroservice.dto.response.UserResponseDTO;
import com.extrawest.usermicroservice.mapper.UserMapper;
import com.extrawest.usermicroservice.model.User;
import com.extrawest.usermicroservice.repository.UserRepository;
import com.extrawest.usermicroservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toUserModel(userRequestDTO);
        return userMapper.toUserResponseDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(userMapper.toUserModel(getUserById(id)));
    }

    @Override
    public UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO) {
        User user = userMapper.toUserModel(userRequestDTO);
        return userMapper.toUserResponseDTO(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user:userList) {
            userResponseDTOList.add(userMapper.toUserResponseDTO(user));
        }
        return userResponseDTOList;
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userMapper.toUserResponseDTO(userRepository.findById(id).orElseThrow());
    }
}
