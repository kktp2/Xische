package com.currencyexhange.currencyexchange.service;

import com.currencyexhange.currencyexchange.model.Billing;
import org.springframework.stereotype.Service;

@Service
public class DiscountContext {
    private IDiscountStrategy discountStrategy;

    public void setDiscountStrategy(IDiscountStrategy  discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(Billing bill) {
        return discountStrategy != null ? discountStrategy.calculateDiscount(bill) : 0.0;
    }

}
