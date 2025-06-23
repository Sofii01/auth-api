package com.app.authapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/admin")
    public String adminEndpoint(){
        return "Access granted: you are an ADMIN!";
    }
    @GetMapping("/public")
    public String publicEndpoint(){
        return "Access granted: PUBLIC!";
    }
    @GetMapping("/user")
    public String userEndpoint(){
        return "Access granted: USER!";
    }
}
