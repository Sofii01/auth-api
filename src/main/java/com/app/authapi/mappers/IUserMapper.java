package com.app.authapi.mappers;

import com.app.authapi.dtos.UserDto;
import com.app.authapi.enums.Role;
import com.app.authapi.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    @Mapping(target = "role", expression = "java(mapSetToRole(user.getRoles()))")
    UserDto toDto(User user);

    @Mapping(target = "roles", expression = "java(mapRoleToSet(dto.role()))")
    User toEntity(UserDto dto);

    default Set<Role> mapRoleToSet(Role role) {
        if (role == null) {
            return new HashSet<>();
        }
        return new HashSet<>(Set.of(role));
    }

    default Role mapSetToRole(Set<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return null;
        }
        return roles.iterator().next();
    }
}
