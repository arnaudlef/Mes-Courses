package com.example.mes_courses_api.list;

import com.example.mes_courses_api.list_item.ListItemInListDTO;

import java.util.List;

public record ListDTO(
        Long id,
        String name,
        List<ListItemInListDTO> items
) {
}
