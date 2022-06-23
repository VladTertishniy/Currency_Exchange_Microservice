package com.extrawest.usermicroservice.mapper;

import com.extrawest.usermicroservice.dto.request.UserRequestDTO;
import com.extrawest.usermicroservice.dto.response.UserResponseDTO;
import com.extrawest.usermicroservice.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRequestDTO toUserRequestDTO(User user);
    UserResponseDTO toUserResponseDTO(User user);
    User toUserModel(UserRequestDTO userRequestDTO);
    User toUserModel(UserResponseDTO userResponseDTO);
}
