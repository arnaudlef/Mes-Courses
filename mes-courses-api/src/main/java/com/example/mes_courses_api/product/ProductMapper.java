package com.example.mes_courses_api.product;

import com.example.mes_courses_api.conf.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<ProductDTO, ProductEntity> {
}
