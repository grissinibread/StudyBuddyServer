package com.studybuddyserver.dtos;

import java.util.List;

public class PublicUserInfoRequest {
    private String firstName;
    private String lastName;
    private Integer age;
    private String major;
    private Integer gradYear;
    private List<String> interests;
    private String bio;

    public PublicUserInfoRequest(String firstName, String lastName, Integer age, String major, Integer gradYear, List<String> interests, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        this.gradYear = gradYear;
        this.interests = interests;
        this.bio = bio;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
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

    public List<String> getInterests() {
        return this.interests;
    }

    public String getBio() {
        return this.bio;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PublicUserInfoRequest)) return false;
        final PublicUserInfoRequest other = (PublicUserInfoRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
        final Object this$major = this.getMajor();
        final Object other$major = other.getMajor();
        if (this$major == null ? other$major != null : !this$major.equals(other$major)) return false;
        final Object this$gradYear = this.getGradYear();
        final Object other$gradYear = other.getGradYear();
        if (this$gradYear == null ? other$gradYear != null : !this$gradYear.equals(other$gradYear)) return false;
        final Object this$interests = this.getInterests();
        final Object other$interests = other.getInterests();
        if (this$interests == null ? other$interests != null : !this$interests.equals(other$interests)) return false;
        final Object this$bio = this.getBio();
        final Object other$bio = other.getBio();
        if (this$bio == null ? other$bio != null : !this$bio.equals(other$bio)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PublicUserInfoRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $age = this.getAge();
        result = result * PRIME + ($age == null ? 43 : $age.hashCode());
        final Object $major = this.getMajor();
        result = result * PRIME + ($major == null ? 43 : $major.hashCode());
        final Object $gradYear = this.getGradYear();
        result = result * PRIME + ($gradYear == null ? 43 : $gradYear.hashCode());
        final Object $interests = this.getInterests();
        result = result * PRIME + ($interests == null ? 43 : $interests.hashCode());
        final Object $bio = this.getBio();
        result = result * PRIME + ($bio == null ? 43 : $bio.hashCode());
        return result;
    }

    public String toString() {
        return "PublicUserInfoRequest(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ", major=" + this.getMajor() + ", gradYear=" + this.getGradYear() + ", interests=" + this.getInterests() + ", bio=" + this.getBio() + ")";
    }
}
