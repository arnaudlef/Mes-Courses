package com.example.mes_courses_api.list;

import com.example.mes_courses_api.user.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("lists")
public class ListController {

    @Resource
    ListService listService;

    @GetMapping("{listId}")
    ListDTO find(@AuthenticationPrincipal UserEntity userEntity, @PathVariable Long listId) {
        return listService.find(userEntity, listId);
    }

    @GetMapping
    List<ListDTO> findAll() {
        return listService.findAll();
    }

    @PatchMapping("{listId}")
    ListDTO update(@PathVariable Long listId, @RequestBody ListDTO updateReq) {
        return listService.update(listId, updateReq);
    }

    @PostMapping()
    ListDTO create(@AuthenticationPrincipal UserEntity userEntity, @RequestBody ListDTO listRequest) {
        return listService.create(userEntity, listRequest);
    }

    @DeleteMapping()
    void delete(@RequestParam Long listId) {
        listService.delete(listId);
    }
}
