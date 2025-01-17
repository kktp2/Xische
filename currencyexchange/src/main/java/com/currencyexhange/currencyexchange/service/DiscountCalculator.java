package com.currencyexhange.currencyexchange.service;

import com.currencyexhange.currencyexchange.model.Billing;
import com.currencyexhange.currencyexchange.model.user.User;
import com.currencyexhange.currencyexchange.model.user.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class DiscountCalculator {
    @Autowired
    private DiscountContext discountContext;

    public double calculateFinalDiscount(Billing bill) {
        if (UserGroup.EMPLOYEE.equals(bill.getUser().getUserType())) {
            discountContext.setDiscountStrategy(new EmployeeDiscount());
        } else if (UserGroup.AFFILIATE.equals(bill.getUser().getUserType())) {
            discountContext.setDiscountStrategy(new AffiliateDiscount());
        } else if (calculateUserTenure(bill.getUser()) > 2) {
            discountContext.setDiscountStrategy(new LongTermDiscount());
        } else {
            discountContext.setDiscountStrategy(new FlatDiscount());
        }

        double percentageDiscount = discountContext.calculateDiscount(bill);

        discountContext.setDiscountStrategy(new FlatDiscount());
        double flatDiscount = discountContext.calculateDiscount(bill);

        return percentageDiscount + flatDiscount;

    }

    private long calculateUserTenure(User user){

        Date subscribedSince = user.getSubscribedSince();
        LocalDate subscriptionDate = subscribedSince.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        long years = ChronoUnit.YEARS.between(subscriptionDate, LocalDate.now());
        return years;
    }
}
