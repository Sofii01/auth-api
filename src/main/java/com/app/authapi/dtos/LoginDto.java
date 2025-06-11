package com.app.authapi.dtos;

public record LoginDto(
        String email,
        String password
) {
}
