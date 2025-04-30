package com.studybuddyserver;

import com.studybuddyserver.entities.User;
import com.studybuddyserver.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudyBuddyServerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudyBuddyServerApplication.class, args);
        var repository = context.getBean(UserRepository.class);

//        // This is how you create a user.
//        var user = User.builder()
//                .firstName("Johnny")
//                .lastName("Qi")
//                .email("qi004@csusm.edu")
//                .password("gilligandsisland")
//                .build();
//
//        repository.save(user);
    }

}