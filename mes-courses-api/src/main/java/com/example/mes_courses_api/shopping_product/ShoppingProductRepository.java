package com.example.mes_courses_api.shopping_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingProductRepository extends JpaRepository<ShoppingProductEntity, Long> {
}
