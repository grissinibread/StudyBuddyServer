package com.studybuddyserver.matching;

import com.studybuddyserver.entities.User;
import java.util.ArrayList;
import java.util.List;

public class Match {
    private String firstName;
    private Integer age;
    private String major;
    private Integer gradYear;
    private List<String> interests = new ArrayList<String>();
    private double rank; // compatibility score

    public Match(User user, double score) {
        this.firstName = user.getFirstName();
        this.age = user.getAge();
        this.major = user.getMajor();
        this.gradYear = user.getGradYear();
        this.interests = user.getInterests();
        this.rank = score;
    }
    public String getFirstName() { return firstName;}
    public Integer getAge() { return age;}
    public String getMajor() { return major;}
    public Integer getGradYear() { return gradYear;}
    public List<String> getInterests() { return interests;}
    public Double getRank() { return rank; }
}
