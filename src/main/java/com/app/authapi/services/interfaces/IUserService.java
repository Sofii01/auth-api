package com.app.authapi.services.interfaces;

import com.app.authapi.dtos.UserDto;
import org.springframework.validation.annotation.Validated;

public interface IUserService {
    UserDto registerUser(@Validated UserDto userDto);
}
