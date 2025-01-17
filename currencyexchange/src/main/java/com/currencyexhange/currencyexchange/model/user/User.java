package com.currencyexhange.currencyexchange.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    private int id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private UserGroup userType;

    @Column
    private Date subscribedSince;

    public User() {
    }

    public User(int id, String name, String email, UserGroup userType, Date subscribedSince) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.subscribedSince = subscribedSince;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
