package com.studybuddyserver.dtos;

public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String major;
    private int gradYear;

    public UpdateUserRequest(String firstName, String lastName, String email, int age, String major, int gradYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.major = major;
        this.gradYear = gradYear;
    }

    public int getAge() {
        return this.age;
    }

    public String getMajor() {
        return this.major;
    }

    public int getGradYear() {
        return this.gradYear;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateUserRequest)) return false;
        final UpdateUserRequest other = (UpdateUserRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        if (this.getAge() != other.getAge()) return false;
        final Object this$major = this.getMajor();
        final Object other$major = other.getMajor();
        if (this$major == null ? other$major != null : !this$major.equals(other$major)) return false;
        if (this.getGradYear() != other.getGradYear()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateUserRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        result = result * PRIME + this.getAge();
        final Object $major = this.getMajor();
        result = result * PRIME + ($major == null ? 43 : $major.hashCode());
        result = result * PRIME + this.getGradYear();
        return result;
    }

    public String toString() {
        return "UpdateUserRequest(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", age=" + this.getAge() + ", major=" + this.getMajor() + ", gradYear=" + this.getGradYear() + ")";
    }
}
