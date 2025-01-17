package com.currencyexhange.currencyexchange.model.user;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private String email;
    private UserGroup userType;
    private Date subscribedSince;

    public User(int id, String name, String email, UserGroup userType, Date subscribedSince) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.subscribedSince = subscribedSince;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                ", subscribedSince=" + subscribedSince +
                '}';
    }

    public Date getSubscribedSince() {
        return subscribedSince;
    }

    public void setSubscribedSince(Date subscribedSince) {
        this.subscribedSince = subscribedSince;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserGroup getUserType() {
        return userType;
    }

    public void setUserType(UserGroup userType) {
        this.userType = userType;
    }
}
