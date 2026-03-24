package com.example.mes_courses_api.shopping_product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shopping_product")
@Getter
@Setter
public class ShoppingProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column()
    String name;

    @Column()
    Integer quantity;
}
