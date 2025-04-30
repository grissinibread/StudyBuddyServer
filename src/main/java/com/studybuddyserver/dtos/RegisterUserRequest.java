package com.studybuddyserver.dtos;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}