package com.example.mes_courses_api.list_item;

import com.example.mes_courses_api.list.ListDTO;
import com.example.mes_courses_api.product.ProductDTO;

public record ListItemDTO (
        Long id,
        ListDTO list,
        ProductDTO product,
        Integer quantity
) {
}
