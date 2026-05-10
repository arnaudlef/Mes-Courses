package com.example.mes_courses_api.user;

import com.example.mes_courses_api.list.ListDTO;
import com.example.mes_courses_api.list.ListInUserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
public class UserDTO {
    Long id;
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) String password;
    Collection<ListInUserDTO> listDTOS;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String role;
}
