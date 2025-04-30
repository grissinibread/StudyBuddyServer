package com.studybuddyserver.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;

@AllArgsConstructor
@Getter
public class UserDto {
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
}