package com.example.mes_courses_api.list_item;

import com.example.mes_courses_api.list.ListEntity;
import com.example.mes_courses_api.list.ListRepository;
import com.example.mes_courses_api.product.ProductEntity;
import com.example.mes_courses_api.product.ProductRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListItemService {
    @Resource
    ListItemRepository listItemRepository;

    @Resource
    ListRepository listRepository;

    @Resource
    ListItemMapper listItemMapper;

    @Resource
    ProductRepository productRepository;

    public ListItemDTO find(Long listItemId) {
        ListItemEntity listItem = listItemRepository.findById(listItemId)
                .orElseThrow(() -> new RuntimeException());

        return listItemMapper.toDto(listItem);
    }

    List<ListItemDTO> findAll() {
        return listItemMapper.toDtoList(listItemRepository.findAll());
    }

    ListItemDTO updateQuantity(Long listItemId, ListItemDTO itemRequest) {
        ListItemEntity listItem = listItemRepository.findById(listItemId)
                .orElseThrow(() -> new IllegalArgumentException("L'item n'existe pas"));

        listItem.setQuantity(itemRequest.quantity());

        return listItemMapper.toDto(listItemRepository.save(listItem));
    }

    ListItemDTO create(ListItemDTO itemRequest) {
        boolean listExist = listRepository.existsById(itemRequest.list().id());

        boolean productExist = productRepository.existsById(itemRequest.product().id());

        if (!listExist || !productExist) {
            throw new RuntimeException();
        }

        ListItemEntity listItem = listItemMapper.toEntity(itemRequest);

        return listItemMapper.toDto(listItemRepository.save(listItem));
    }

    @Transactional
    void delete(Long listItemId) {
        ListItemEntity listItem = listItemRepository.findById(listItemId)
                .orElseThrow(() -> new IllegalArgumentException("L'item n'existe pas"));
        listItemRepository.delete(listItem);
    }
}
