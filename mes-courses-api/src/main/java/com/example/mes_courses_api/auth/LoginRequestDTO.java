package com.example.mes_courses_api.auth;

public record LoginRequestDTO(
        String email,
        String password
) {
}
