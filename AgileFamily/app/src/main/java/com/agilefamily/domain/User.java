package com.agilefamily.domain;

public class User {
    public String name;
    public UserType userType;
    public User(String name, UserType userType) {
        this.name = name;
        this.userType = userType;
    }
}
