package com.studybuddyserver.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "SB_users")
public class User {
    @Id
    @Field("_id")
    private ObjectId id;

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
    private Integer gradYear;

    @Field("interests")
    private List<String> interests;

    @Field("bio")
    private String bio;

    public User(ObjectId id, String firstName, String lastName, String email, String password, Integer age, String major, Integer gradYear, List<String> interests, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.major = major;
        this.gradYear = gradYear;
        this.interests = interests;
        this.bio = bio;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

//    private String interest1;
//    private String interest2;
//    private String interest3;
//    private List<Match> matches = new ArrayList<Match>();

//    public User(String fname, String lname, Integer age, String major, Integer gradYear, String bio, String interest1,
//                String interest2, String interest3, String email, String password) {
//        this.name = fname + " " + lname; // whole name (maybe not needed in the end)
//        this.firstName = fname; this.lastName = lname; // single names
//        this.age = age;
//        this.major = major; this.gradYear = gradYear;
//        this.bio = bio;
//        this.interest1 = interest1; this.interest2 = interest2; this.interest3 = interest3;

    /// /        this.interests.add(interest1); this.interests.add(interest2); this.interests.add(interest3);
//        this.email = email; this.password = password;
//    }
    public ObjectId getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getMajor() {
        return this.major;
    }

    public Integer getGradYear() {
        return this.gradYear;
    }

    public String getBio() {
        return bio;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setgradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    public String toString() {
        return "User(Id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", age=" + this.getAge() + ", major=" + this.getMajor() + ", gradYear=" + this.getGradYear() + ")";
    }

    public static class UserBuilder {
        private String Id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Integer age;
        private String major;
        private Integer gradYear;
        private ObjectId id;
        private List<String> interests;
        private String bio;

        UserBuilder() {
        }

        public String toString() {
            return "User.UserBuilder(Id=" + this.Id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", password=" + this.password + ", age=" + this.age + ", major=" + this.major + ", gradYear=" + this.gradYear + ")";
        }

        public UserBuilder id(ObjectId id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder major(String major) {
            this.major = major;
            return this;
        }

        public UserBuilder gradYear(Integer gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public UserBuilder interests(List<String> interests) {
            this.interests = interests;
            return this;
        }

        public UserBuilder bio(String bio) {
            this.bio = bio;
            return this;
        }

        public User build() {
            return new User(this.id, this.firstName, this.lastName, this.email, this.password, this.age, this.major, this.gradYear, this.interests, this.bio);
        }
    }

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
