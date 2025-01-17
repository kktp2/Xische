package com.currencyexhange.currencyexchange.model;

import com.currencyexhange.currencyexchange.model.item.Item;
import com.currencyexhange.currencyexchange.model.user.User;

import java.util.List;

public class Billing {
    private List<Item> items;
    private User user;
    private String originalCurrency;
    private String targetCurrency;

    public List<Item> getItems() {
        return items;
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
}
