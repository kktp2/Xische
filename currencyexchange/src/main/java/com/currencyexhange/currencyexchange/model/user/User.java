package com.currencyexhange.currencyexchange.model.user;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private UserGroup userType;
    private Date subscribedSince;

    public Date getCreationDate() {
        return subscribedSince;
    }

    public void setCreationDate(Date creationDate) {
        this.subscribedSince = creationDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserGroup getUserType() {
        return userType;
    }

    public void setUserType(UserGroup userType) {
        this.userType = userType;
    }
}
