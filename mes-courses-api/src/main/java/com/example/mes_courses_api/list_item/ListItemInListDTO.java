package com.example.mes_courses_api.list_item;

import com.example.mes_courses_api.product.ProductDTO;

public record ListItemInListDTO(
        Long id,
        ProductDTO product,
        Integer quantity
) {
}
