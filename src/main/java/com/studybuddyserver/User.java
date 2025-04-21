package com.studybuddyserver;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String fname;
    private String lname;
    private Integer age; //not changeable after sign up
    private String major;
    private Integer gradYr;
    private List<String> interests = new ArrayList<String>();
    private String interest1;
    private String interest2;
    private String interest3;
    private String email;
    private String password;
    private String bio;
    private List<Match> matches = new ArrayList<Match>();

    public User(String fname, String lname, Integer age, String major, Integer gradYr, String bio, String interest1,
                String interest2, String interest3, String email, String password) {
        this.name = fname + " " + lname; // whole name (maybe not needed in the end)
        this.fname = fname; this.lname = lname; // single names
        this.age = age;
        this.major = major; this.gradYr = gradYr;
        this.bio = bio;
        this.interest1 = interest1; this.interest2 = interest2; this.interest3 = interest3;
        this.interests.add(interest1); this.interests.add(interest2); this.interests.add(interest3);
        this.email = email; this.password = password;
    }
    // required for signup, but can be edited later
    public void editName(String fname, String lname) {
        this.fname = fname; this.lname = lname;
        this.name = fname + " " + lname;
    }
    public String getName(char indicator) { // char = f for fname, l for lname, n for full name
        return switch (indicator) {
            case 'f' -> fname;
            case 'l' -> lname;
            case 'n' -> name;
            default -> null;
        };
    }

    public Integer getAge() { return this.age; } //cannot be edited

    public void editMajor(String major) { this.major = major; }
    public String getMajor() { return major; }

    public void editGradYr(Integer gradYr) { this.gradYr = gradYr; }
    public Integer getGradYr() { return gradYr; }

    public void editEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void editPassword(String password) { this.password = password; }
    public String getPassword() { return password; }

    public void editInterest(String interest1, String interest2, String interest3) {
        this.interest1 = interest1; this.interest2 = interest2; this.interest3 = interest3;
        this.interests.add(interest1); this.interests.add(interest2); this.interests.add(interest3);
    }
    public String getInterest(int i) { return interests.get(i); }

    // not required during sign up but encouraged later
    public void editBio(String bio) {
        // TODO: set a char count on the bio, maybe will be done here, maybe in edit profile page
        this.bio = bio;
    }
    public String getBio() { return bio; }

    public void setMatches(List<Match> matches) { this.matches = matches; }
    public List<Match> getMatches() { return matches; }

    //iterator pattern
    public MatchIterator getMatchIterator(){ return new MatchIterator(matches); }
}
