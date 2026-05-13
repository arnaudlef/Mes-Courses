package com.example.mes_courses_api.list_item;

import com.example.mes_courses_api.conf.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListItemMapper extends GenericMapper<ListItemDTO, ListItemEntity> {
}
