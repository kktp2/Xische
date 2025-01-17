package com.currencyexhange.currencyexchange.service;

import com.currencyexhange.currencyexchange.model.Billing;

public interface IDiscountStrategy {
    double calculateDiscount(Billing bill);
}
