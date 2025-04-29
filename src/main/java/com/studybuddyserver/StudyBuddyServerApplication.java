package com.studybuddyserver;

import com.studybuddyserver.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyBuddyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyBuddyServerApplication.class, args);

        var user = new User();
        user.setAge(10);
        user.setEmail("alexnavarro57@gmail.com");
    }

}