package com.app.authapi.dtos;

import com.app.authapi.enums.Role;

public record UserDto(
        String email,
        String password,
        Role role
) {
}
