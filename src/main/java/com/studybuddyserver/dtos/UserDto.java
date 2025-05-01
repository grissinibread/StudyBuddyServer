package com.studybuddyserver.dtos;

import org.bson.types.ObjectId;

public class UserDto {
    private final ObjectId id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public UserDto(ObjectId id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ObjectId getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }
}