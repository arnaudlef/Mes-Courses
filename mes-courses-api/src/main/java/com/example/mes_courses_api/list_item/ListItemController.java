package com.example.mes_courses_api.list_item;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("list-items")
public class ListItemController {

    @Resource
    ListItemService listItemService;

    @GetMapping
    List<ListItemDTO> findAll() {
        return listItemService.findAll();
    }

    @GetMapping("{listItemId}")
    ListItemDTO find(@PathVariable Long listItemId) {
        return listItemService.find(listItemId);
    }

    @PatchMapping()
    ListItemDTO update(@RequestParam Long listItemId, @RequestBody ListItemDTO itemRequest) {
        return listItemService.updateQuantity(listItemId, itemRequest);
    }

    @PostMapping()
    ListItemDTO create(@RequestBody ListItemDTO itemRequest) {
        return listItemService.create(itemRequest);
    }

    @DeleteMapping()
    void delete(@RequestParam Long listItemId) {
        listItemService.delete(listItemId);
    }
}
