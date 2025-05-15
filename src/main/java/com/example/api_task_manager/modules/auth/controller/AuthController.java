package com.example.api_task_manager.modules.auth.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api_task_manager.modules.auth.dto.LoginRequest;
import com.example.api_task_manager.modules.auth.dto.LoginResponse;
import com.example.api_task_manager.modules.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
