package com.example.mes_courses_api.auth;

import com.example.mes_courses_api.user.UserDTO;
import com.example.mes_courses_api.user.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Resource
    AuthService authService;

    @GetMapping("me")
    UserDTO me(@AuthenticationPrincipal UserEntity userEntity) {
        return authService.getCurrentUser(userEntity);
    }

    @PostMapping("login")
    AuthResponse authenticateUser(@RequestBody LoginRequestDTO request) {
        return authService.loginUser(request);
    }

    @PostMapping("register")
    UserDTO registerUser(@RequestBody UserDTO userDTO) {
        return authService.registerUser(userDTO);
    }

    @PostMapping("refresh")
    AuthResponse refresh(@RequestBody String refreshToken) {
        return authService.refreshToken(refreshToken);
    }
}