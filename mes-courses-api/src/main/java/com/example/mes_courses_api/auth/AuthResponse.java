package com.example.mes_courses_api.auth;

public record AuthResponse(
        String accessToken,
        String refreshToken
) {
}
