package com.studybuddyserver.matching;

import com.studybuddyserver.entities.User;
import java.util.ArrayList;
import java.util.List;

public class Match {
    private String name;
    private Integer age;
    private String major;
    private Integer gradYr;
    private List<String> interests = new ArrayList<String>();
    private double rank; // compatibility score

    public Match(User user, double score) {
        this.name = user.getFirstName();
        this.age = user.getAge();
        this.major = user.getMajor();
        this.gradYr = user.getGradYear();
        this.interests = user.getInterests();
        this.rank = score;
    }

    public Double getRank() { return this.rank; }
}
