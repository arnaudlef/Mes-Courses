package com.example.mes_courses_api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    Long id;
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) String password;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String role;
}
