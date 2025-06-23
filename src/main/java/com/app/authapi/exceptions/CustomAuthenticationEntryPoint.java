package com.app.authapi.exceptions;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        String body = String.format("""
                {
                    "status": 401,
                    "error": "Unauthorized",
                    "message": "%s",
                    "path": "%s",
                    "timestamp": "%s"
                }
                """,
                authException.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now());

        response.getWriter().write(body);
    }
}
