package com.studybuddyserver.dtos;

import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
public class UserDto {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public UserDto(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}