package com.studybuddyserver.entities;
import com.studybuddyserver.matching.Match;
import com.studybuddyserver.matching.MatchIterator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@Document(collection = "SB_users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field("_id")
    private Long Id;

    @Field("fname")
    private String firstName;

    @Field("lname")
    private String lastName;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    //cannot be edited

    @Field("age")
    private Integer age; //not changeable after sign up

    @Field("major")
    private String major;

    @Field("gradYear")
    private Integer gradYr;

//    private List<String> interests = new ArrayList<String>();
//    private String interest1;
//    private String interest2;
//    private String interest3;
//    private String bio;
//    private List<Match> matches = new ArrayList<Match>();

//    public User(String fname, String lname, Integer age, String major, Integer gradYr, String bio, String interest1,
//                String interest2, String interest3, String email, String password) {
//        this.name = fname + " " + lname; // whole name (maybe not needed in the end)
//        this.firstName = fname; this.lastName = lname; // single names
//        this.age = age;
//        this.major = major; this.gradYr = gradYr;
//        this.bio = bio;
//        this.interest1 = interest1; this.interest2 = interest2; this.interest3 = interest3;
////        this.interests.add(interest1); this.interests.add(interest2); this.interests.add(interest3);
//        this.email = email; this.password = password;
//    }

    // required for signup, but can be edited later
    public void editName(String fname, String lname) {
        this.firstName = fname; this.lastName = lname;
//        this.name = fname + " " + lname;
    }

    public String getName(char indicator) { // char = f for fname, l for lname, n for full name
        switch (indicator) {
            case 'f': return firstName;
            case 'l': return lastName;
//            case 'n': return name;
            default: return null;
        }
    }

    public void editMajor(String major) { this.major = major; }

    public void editGradYr(Integer gradYr) { this.gradYr = gradYr; }

    public void editEmail(String email) { this.email = email; }

    public void editPassword(String password) { this.password = password; }

//    public void editInterest(String interest1, String interest2, String interest3) {
//        this.interest1 = interest1; this.interest2 = interest2; this.interest3 = interest3;
////        this.interests.add(interest1); this.interests.add(interest2); this.interests.add(interest3);
//    }

//    public String getInterest(int i) { return interests.get(i); }

    // not required during sign up but encouraged later
//    public void editBio(String bio) {
//        // TODO: set a char count on the bio, maybe will be done here, maybe in edit profile page
//        this.bio = bio;
//    }

//    public String getBio() { return bio; }
//    public void setMatches(List<Match> matches) { this.matches = matches; }
//    public List<Match> getMatches() { return matches; }
//
//    //iterator pattern
//    public MatchIterator getMatchIterator(){ return new MatchIterator(matches); }

}
