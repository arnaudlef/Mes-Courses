package com.example.mes_courses_api.list;

import com.example.mes_courses_api.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {
    Optional<ListEntity> findByIdAndUserId(Long listId, Long userId);
    Optional<List<ListEntity>> findByUserId(Long userId);
}
