package com.example.mes_courses_api.shopping_list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shopping-lists")
public class ShoppingListController {
    @GetMapping
    List<ShoppingList> findAll() {
        return List.of();
    }
}
