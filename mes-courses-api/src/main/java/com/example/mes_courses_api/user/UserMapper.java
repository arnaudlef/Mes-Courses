package com.example.mes_courses_api.user;

import com.example.mes_courses_api.conf.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDTO, UserEntity> {
}
