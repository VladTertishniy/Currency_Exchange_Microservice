package com.extrawest.usermicroservice.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AuthRequestDTO {
    @Email
    private String email;
    @NotNull(message = "Password is required!")
    @Size(min = 3, max = 18, message = "Password length must be not less 3, and not more that 18!")
    private String password;
}
