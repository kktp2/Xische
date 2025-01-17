package com.currencyexhange.currencyexchange.model;

import com.currencyexhange.currencyexchange.model.item.Item;
import com.currencyexhange.currencyexchange.model.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class Billing {
    @NotNull
    private List<Item> items;
    private User user;
    @NotBlank(message = "User Email can not be blank")
    private String userEmail;
    @NotBlank(message = "Original currency can not be blank")
    private String originalCurrency;
    @NotBlank(message = "Target currency can not be blank")
    private String targetCurrency;

    public List<Item> getItems() {
        return items;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "items=" + items +
                ", user=" + user +
                ", userEmail='" + userEmail + '\'' +
                ", originalCurrency='" + originalCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                '}';
    }
}
