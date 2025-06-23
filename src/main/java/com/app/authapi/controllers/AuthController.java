package com.app.authapi.controllers;

import com.app.authapi.dtos.AuthDto;
import com.app.authapi.dtos.LoginDto;
import com.app.authapi.dtos.UserDto;
import com.app.authapi.jwt.CustomUserDetailsService;
import com.app.authapi.jwt.JwtService;
import com.app.authapi.models.entities.User;
import com.app.authapi.repositories.IUserRepository;
import com.app.authapi.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IUserService userService;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final IUserRepository userRepository; //temporal despues factorizo
    private final CustomUserDetailsService customUserDetailsService;

    public AuthController(IUserService userService, AuthenticationManager authManager, JwtService jwtService, IUserRepository userRepository, CustomUserDetailsService customUserDetailsService) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto user = userService.registerUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public AuthDto login(@RequestBody LoginDto loginDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(), loginDto.password()
                )
        );
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDto.email());
        String token = jwtService.generateToken(userDetails);
        return new AuthDto(token);
    }
}
