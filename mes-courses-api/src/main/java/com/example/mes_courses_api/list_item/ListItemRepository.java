package com.example.mes_courses_api.list_item;

import com.example.mes_courses_api.list.ListEntity;
import com.example.mes_courses_api.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ListItemRepository extends JpaRepository<ListItemEntity, Long> {
    void deleteByProduct(ProductEntity product);

    void deleteByList(ListEntity list);
}
