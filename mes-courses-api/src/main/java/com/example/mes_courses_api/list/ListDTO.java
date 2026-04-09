package com.example.mes_courses_api.list;

import com.example.mes_courses_api.list_item.ListItemInListDTO;
import com.example.mes_courses_api.user.UserEntity;

import java.util.List;

public record ListDTO(
        Long id,
        UserEntity userEntity,
        String name,
        List<ListItemInListDTO> items
) {
}
