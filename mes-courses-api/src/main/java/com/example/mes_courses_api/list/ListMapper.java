package com.example.mes_courses_api.list;

import com.example.mes_courses_api.conf.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListMapper extends GenericMapper<ListDTO, ListEntity> {
}
