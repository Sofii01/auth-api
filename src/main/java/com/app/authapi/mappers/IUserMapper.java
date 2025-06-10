package com.app.authapi.mappers;

import com.app.authapi.dtos.UserDto;
import com.app.authapi.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
