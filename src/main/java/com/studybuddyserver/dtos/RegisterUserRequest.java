package com.studybuddyserver.dtos;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class RegisterUserRequest {
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
}