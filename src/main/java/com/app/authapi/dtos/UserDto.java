package com.app.authapi.dtos;

import com.app.authapi.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotNull(message = "Email must not be null")
        @Email(message = "Email must be valid")
        String email,
        @NotNull(message = "Password must not be null")
        @Size(min = 6, message = "Password must be at least 6 characters ")
        String password,
        Role role
) {
}
