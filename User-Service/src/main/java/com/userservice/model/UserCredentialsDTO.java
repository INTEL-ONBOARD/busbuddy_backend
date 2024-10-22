package com.userservice.model;

public class UserCredentialsDTO {

    private String email;
    private String password;

    // Constructors
    public UserCredentialsDTO() {}

    public UserCredentialsDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Optionally, you can add toString(), equals(), and hashCode() methods as well
    @Override
    public String toString() {
        return "UserCredentialsDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
