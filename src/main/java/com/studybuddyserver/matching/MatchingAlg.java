package com.studybuddyserver.matching;

import com.studybuddyserver.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.abs;

@Component
public class MatchingAlg {
    @Autowired
    private MongoTemplate mongoTemp;

    //returns list of matches
    public List<Match> returnMatches(User loggedInUser){
        List<Match> sortedMatches = new ArrayList<>();

        // list of all users except the logged-in user
        List<User> allUsers = mongoTemp.findAll(User.class);
        allUsers.removeIf(user -> user.getId().equals(loggedInUser.getId()));

        //rank each user
        for (User currentUser : allUsers) {
            double rank = rankUser(loggedInUser, currentUser);
            if (rank >= 5){
                Match currentMatch = new Match(currentUser, rank);
                sortedMatches.add(currentMatch);
            }
        }
        // sort matches by rank (highest first)
        sortedMatches.sort(Comparator.comparingDouble(Match::getRank).reversed());

        return sortedMatches;
    }

    // actual matching criteria: return a double
    private double rankUser(User user1, User user2){
        double rank = 0;
        //major
        if((user1.getMajor() != null && user2.getMajor() != null) //both users must have a major to be able to match
                && user1.getMajor().equals(user2.getMajor())){ // major are the same
            rank += 10;
        }
        //grad yr
        if(user1.getGradYear() != null && user2.getGradYear() != null){ //both must have grad yr
            rank += 4 - abs(user1.getGradYear() - user2.getGradYear());
        }
        //age
        if( user1.getAge() != null && user2.getAge() != null //both have age fields
                && abs(user1.getAge() - user2.getAge()) <= 3){ //difference up to three years of age earns a point
            rank += 1;
        }
        //interests
        if(user1.getInterests() != null && user2.getInterests() != null){
            for (String interest : user1.getInterests()) {
                if (user2.getInterests().contains(interest)) {
                    rank += 2;
                }
            }
        }
        return rank;
    }

}
