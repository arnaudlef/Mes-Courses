package com.example.mes_courses_api.shopping_product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingProductService {

    @Resource
    ShoppingProductRepository shoppingProductRepository;

    public ShoppingProductEntity find(Long shoppingProductId) {
        ShoppingProductEntity shoppingProduct = shoppingProductRepository.findById(shoppingProductId)
                .orElseThrow(() -> new RuntimeException());

        return shoppingProduct;
    }

    List<ShoppingProductEntity> findAll() {
        return shoppingProductRepository.findAll();
    }

//    Product createShoppingProduct(ShoppingProduct shoppingProduct) {
//        return shoppingProduct;
//    }
}
