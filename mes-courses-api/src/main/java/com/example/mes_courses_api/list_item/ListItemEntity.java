package com.example.mes_courses_api.list_item;

import com.example.mes_courses_api.list.ListEntity;
import com.example.mes_courses_api.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(
        name = "list_item",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_list_item", columnNames = {"list_id", "product_id"})
        }
)
@Getter
@Setter
public class ListItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    ListEntity list;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    ProductEntity product;

    @Column()
    Integer quantity;

    @Column(name="purchased", columnDefinition = "boolean default false")
    boolean purchased;
}
