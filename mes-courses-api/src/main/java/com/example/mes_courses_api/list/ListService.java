package com.example.mes_courses_api.list;

import com.example.mes_courses_api.list_item.ListItemRepository;
import com.example.mes_courses_api.user.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListService {

    @Resource
    ListRepository listRepository;

    @Resource
    ListItemRepository listItemRepository;

    @Resource
    ListMapper listMapper;

    public ListDTO find(UserEntity userEntity, Long listId) {
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException());

        return listMapper.toDto(list);
    }

    List<ListDTO> findAll() {
        return listMapper.toDtoList(listRepository.findAll());
    }

    ListDTO create(UserEntity userEntity, ListDTO listRequest) {
        ListEntity listEntity = listMapper.toEntity(listRequest);
        listEntity.setUser(userEntity);
        return listMapper.toDto(listRepository.save(listEntity));
    }

    ListDTO update(Long listId, ListDTO updateReq) {
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new IllegalArgumentException("La liste n'existe pas"));
        list.setName(updateReq.name());
        list.setUpdatedAt(LocalDateTime.now());
        return listMapper.toDto(listRepository.save(list));
    }

    @Transactional
    void delete (Long listId) {
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new IllegalArgumentException("La liste n'existe pas"));
        listItemRepository.deleteByList(list);
        listRepository.delete(list);
    }
}
