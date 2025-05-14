package com.studybuddyserver;

import com.studybuddyserver.controllers.UserController;
import com.studybuddyserver.dtos.PublicUserInfoRequest;
import com.studybuddyserver.dtos.UserDto;
import com.studybuddyserver.entities.User;
import com.studybuddyserver.matching.Match;
import com.studybuddyserver.matching.MatchCollection;
import com.studybuddyserver.matching.MatchDisplay;
import com.studybuddyserver.matching.MatchingAlg;
import com.studybuddyserver.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudyBuddyServerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudyBuddyServerApplication.class, args);
        var repository = context.getBean(UserRepository.class);
        MatchingAlg matchingAlg = context.getBean(MatchingAlg.class);
        UserController userController = context.getBean(UserController.class);

//        // This is how you create a user.
//        var user = User.builder()
//                .firstName("Johnny")
//                .lastName("Qi")
//                .email("qi004@csusm.edu")
//                .password("gilligandsisland")
//                .build();
//
//        repository.save(user);

        Iterable<PublicUserInfoRequest> list = userController.getAllUsers();
        for (PublicUserInfoRequest publicUserInfoRequest : list) {
            System.out.println(publicUserInfoRequest.getFirstName());
        }
        System.out.println("list end\n");

        // get all users
        List<User> users = repository.findAll();
        User loggedIn = users.get(3);
        List<Match> matches = matchingAlg.returnMatches(loggedIn);
        MatchCollection matchCollection = new MatchCollection(matches);
        MatchDisplay matchDisplay = new MatchDisplay(matchCollection);
        System.out.println();
        System.out.println("User to be matched: " + loggedIn);
        matchDisplay.printMatches();
//        int i = 1;
//        for (Match match : matches) {
//            System.out.println("Match " + i +"- Name: " + match.getName()+ ", Rank: " + match.getRank());
//            i++;
//        }
    }
}