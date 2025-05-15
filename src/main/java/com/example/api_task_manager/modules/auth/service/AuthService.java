package com.example.api_task_manager.modules.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.api_task_manager.modules.auth.dto.LoginRequest;
import com.example.api_task_manager.modules.auth.dto.LoginResponse;

import java.util.Map;

@Service
public class AuthService {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.api.key}")
    private String supabaseApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public LoginResponse login(LoginRequest request) {
        String authUrl = supabaseUrl + "/auth/v1/token?grant_type=password";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("apikey", supabaseApiKey);

        HttpEntity<Map<String, String>> httpRequest = new HttpEntity<>(
                Map.of("email", request.email(), "password", request.password()), headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                authUrl, HttpMethod.POST, httpRequest, Map.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Login inválido no Supabase");
        }

        Map body = response.getBody();
        String token = (String) body.get("access_token");

        return new LoginResponse(token, "Bearer");
    }
}
