package com.studybuddyserver.repositories;

import com.studybuddyserver.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}