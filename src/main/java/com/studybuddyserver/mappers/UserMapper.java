package com.studybuddyserver.mappers;

import com.studybuddyserver.dtos.RegisterUserRequest;
import com.studybuddyserver.dtos.UpdateUserRequest;
import com.studybuddyserver.dtos.UserDto;
import com.studybuddyserver.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest register);

    @Mapping(target = "id", ignore = true)
    void updateUser(UpdateUserRequest updateUserRequest, @MappingTarget User user);
}