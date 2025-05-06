package com.studybuddyserver.mappers;

import com.studybuddyserver.dtos.*;
import com.studybuddyserver.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest register);
    PublicUserInfoRequest info(User user);
    UserDto loginRequest(User user);

    @Mapping(target = "id", ignore = true)
    void updateUser(UpdateUserRequest updateUserRequest, @MappingTarget User user);
}