package com.studybuddyserver.dtos;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class UpdateUserRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
