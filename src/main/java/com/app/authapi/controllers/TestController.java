package com.app.authapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/admin")
    @Operation(summary = "Test a admin endpoint")
    @SecurityRequirement(name = "bearerAuth")
    public String adminEndpoint(){
        return "Access granted: you are an ADMIN!";
    }
    @GetMapping("/public")
    @Operation(summary = "Test public endpoint")
    public String publicEndpoint(){
        return "Access granted: PUBLIC!";
    }
    @GetMapping("/user")
    @Operation(summary = "Test a user endpoint")
    @SecurityRequirement(name = "bearerAuth")
    public String userEndpoint(){
        return "Access granted: USER!";
    }
}
