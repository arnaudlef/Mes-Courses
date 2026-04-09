package com.example.mes_courses_api.list_item;

import com.example.mes_courses_api.conf.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ListItemMapper extends GenericMapper<ListItemDTO, ListItemEntity> {
//    @Mapping(target = "list", ignore = true)
//    ListItemDTO toDto(ListItemEntity listItemEntity);
}
