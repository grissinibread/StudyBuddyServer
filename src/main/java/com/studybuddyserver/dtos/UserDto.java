package com.studybuddyserver.dtos;

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

    public String getId() {
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