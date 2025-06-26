package com.app.authapi.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotNull(message = "Email must not be null")
        @Email(message = "Email must be valid")
        String email,
        @Size(min = 6, message = "Password must be at least 6 characters ")
        String password
) {
}
