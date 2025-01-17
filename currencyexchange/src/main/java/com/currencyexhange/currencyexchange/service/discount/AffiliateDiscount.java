package com.currencyexhange.currencyexchange.service.discount;

import com.currencyexhange.currencyexchange.model.Billing;
import com.currencyexhange.currencyexchange.model.item.Category;

public class AffiliateDiscount implements IDiscountStrategy{

    @Override
    public double calculateDiscount(Billing billing) {

            return billing.getItems().stream()
                    .filter(item -> !Category.GROCERIES.equals(item.getCategory()))
                    .mapToDouble(item -> item.getPrice() * 0.10)
                    .sum();

    }
}
