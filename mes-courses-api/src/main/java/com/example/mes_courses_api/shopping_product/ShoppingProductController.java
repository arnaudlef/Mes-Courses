package com.example.mes_courses_api.shopping_product;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shopping-products")
public class ShoppingProductController {

    @Resource
    ShoppingProductService shoppingProductService;

    @GetMapping
    List<ShoppingProductEntity> findAll() {
        return shoppingProductService.findAll();
    }

    @GetMapping("{shoppingProductId}")
    ShoppingProductEntity find(@PathVariable Long shoppingProductId) {
        return shoppingProductService.find(shoppingProductId);
    }
}
