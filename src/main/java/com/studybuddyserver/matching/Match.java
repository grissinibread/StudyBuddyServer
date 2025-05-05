package com.studybuddyserver.matching;

import com.studybuddyserver.entities.User;
import java.util.ArrayList;
import java.util.List;

//separate class for matched users so their info isn't leaked
public class Match {
    private String name;
    private Integer age;
    private String major;
    private Integer gradYear;
    private List<String> interests = new ArrayList<String>();
    private double score; // compatibility score

    public Match(User user, double score) {
        this.name = user.getName('f');
        this.age = user.getAge();
        this.major = user.getMajor();
        this.gradYear = user.getGradYear();
        // add all 3 interests
//        this.interests.add(user.getInterest(0)); this.interests.add(user.getInterest(1)); this.interests.add(user.getInterest(2));
        this.score = score;
    }
}
