package com.userservice.model;

public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String firstName; // New field
    private String lastName;  // New field
    private String phone;     // New field
    private String bio;       // New field

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getFirstName() {
        return firstName; // Getter for firstName
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName; // Setter for firstName
    }

    public String getLastName() {
        return lastName; // Getter for lastName
    }

    public void setLastName(String lastName) {
        this.lastName = lastName; // Setter for lastName
    }

    public String getPhone() {
        return phone; // Getter for phone
    }

    public void setPhone(String phone) {
        this.phone = phone; // Setter for phone
    }

    public String getBio() {
        return bio; // Getter for bio
    }

    public void setBio(String bio) {
        this.bio = bio; // Setter for bio
    }
}
