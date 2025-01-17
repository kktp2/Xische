package com.currencyexhange.currencyexchange.service.discount;

import com.currencyexhange.currencyexchange.model.Billing;

public class FlatDiscount implements IDiscountStrategy{
    @Override
    public double calculateDiscount(Billing billing) {
        double totalAmount = billing.getItems().stream()
                .mapToDouble(item -> item.getPrice())
                .sum();
        return Math.floor(totalAmount / 100) * 5;
    }
}
