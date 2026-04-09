package com.example.mes_courses_api.product;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Resource
    ProductService productService;

    @GetMapping
    List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @GetMapping("{productId}")
    ProductEntity find(@PathVariable Long productId) {
        return productService.find(productId);
    }

    @PatchMapping("{productId}")
    ProductDTO update(@PathVariable Long productId, @RequestBody ProductDTO updateReq) {
        return productService.update(productId, updateReq);
    }

    @PostMapping()
    ProductDTO create(@RequestBody ProductDTO productRequest) {
        return productService.create(productRequest);
    }

    @DeleteMapping()
    void delete(@RequestParam Long productId) {
        productService.delete(productId);
    }
}
