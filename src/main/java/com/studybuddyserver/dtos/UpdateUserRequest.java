package com.studybuddyserver.dtos;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
}
