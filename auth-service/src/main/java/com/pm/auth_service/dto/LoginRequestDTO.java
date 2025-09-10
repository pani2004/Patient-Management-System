package com.pm.auth_service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @NotBlank(message = "email is required")
    @Email(message = "pls enter a valid email address")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8,message = "Password must be 8 characters long")
    private String password;
}
