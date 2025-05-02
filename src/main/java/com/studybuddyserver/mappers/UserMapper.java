package com.studybuddyserver.mappers;

import com.studybuddyserver.dtos.RegisterUserRequest;
import com.studybuddyserver.dtos.UserDto;
import com.studybuddyserver.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest register);
}