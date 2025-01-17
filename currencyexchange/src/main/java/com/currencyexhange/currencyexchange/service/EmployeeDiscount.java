package com.currencyexhange.currencyexchange.service;

import com.currencyexhange.currencyexchange.model.Billing;
import com.currencyexhange.currencyexchange.model.item.Category;

public class EmployeeDiscount implements IDiscountStrategy {
    @Override
    public double calculateDiscount(Billing bill) {
        return bill.getItems().stream()
                .filter(item -> !Category.GROCERIES.equals(item.getCategory()))
                .mapToDouble(item -> item.getPrice() * 0.30)
                .sum();
    }
}
