package com.studybuddyserver.repositories;

import com.studybuddyserver.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByIdNot(String Id);
    List<User> findByEmailNot(String email);
    User findByEmail(String email);
}