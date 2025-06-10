package com.app.authapi.controllers;

import com.app.authapi.dtos.UserDto;
import com.app.authapi.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IUserService userService;

    public AuthController(IUserService userService) {
        this.userService = userService;
    }
    @PostMapping()
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto user = userService.registerUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
