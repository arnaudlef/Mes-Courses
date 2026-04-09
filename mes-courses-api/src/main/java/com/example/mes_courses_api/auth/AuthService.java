package com.example.mes_courses_api.auth;

import com.example.mes_courses_api.user.UserDTO;
import com.example.mes_courses_api.user.UserEntity;
import com.example.mes_courses_api.user.UserMapper;
import com.example.mes_courses_api.user.UserRepository;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Resource
    UserRepository userRepository;

    @Resource
    BCryptPasswordEncoder passwordEncoder;

    @Resource
    AuthenticationManager authenticationManager;

    @Resource
    JwtService jwtService;

    @Resource
    UserMapper userMapper;

    private final UserDetailsService userDetailsService;


    public Optional<UserEntity> optionalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() ||
                authentication.getPrincipal() != null &&
                        authentication.getPrincipal().equals("anonymousUser")) {
            throw new IllegalArgumentException("L'utilisateur n'est pas connecté");
        }

        try {
            return Optional.ofNullable((UserEntity) authentication.getPrincipal());
        } catch (Exception exception) {
            return Optional.empty();
        }
    }

    public UserDTO getCurrentUser(UserEntity userEntity) {
        return userMapper.toDto(userEntity);
    }

    public AuthResponse loginUser(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.email(),
                        loginRequestDTO.password()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        return new AuthResponse(jwtToken, refreshToken);
    }

    public UserDTO registerUser(UserDTO userDTO) {
        boolean userExist = userRepository.existsByEmail(userDTO.getEmail());
        if (userExist) {
            throw new IllegalArgumentException("L'email est déjà utilisé");
        }

        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserEntity userEntity = userRepository.save(userMapper.toEntity(userDTO));

        return userMapper.toDto(userEntity);
    }

    public AuthResponse refreshToken(String refreshToken) {
        String email = jwtService.extractUsername(refreshToken);

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        if (jwtService.isTokenValid(refreshToken, userDetails)) {
            String jwtToken = jwtService.generateToken(userDetails);
            refreshToken = jwtService.generateRefreshToken(userDetails);

            return new AuthResponse(jwtToken, refreshToken);
        }

        throw new IllegalArgumentException("Le token n'est plus valide");
    }

    public Map<String, String> sendEmailForgotPassword(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("L'utilisateur n'existe pas"));

        UserDetails userDetails = UserEntity.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .build();

        String token = jwtService.generateToken(userDetails);
        return Map.of("token", token);
    }


    public void updatePassword(Long id, String newPassword) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("L'utilisateur n'existe pas"));
        userEntity.setPassword(passwordEncoder.encode(newPassword));
    }
}
