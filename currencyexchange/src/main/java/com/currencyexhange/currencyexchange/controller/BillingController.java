package com.currencyexhange.currencyexchange.controller;

import com.currencyexhange.currencyexchange.model.Billing;
import com.currencyexhange.currencyexchange.model.user.User;
import com.currencyexhange.currencyexchange.model.user.UserGroup;
import com.currencyexhange.currencyexchange.service.DiscountCalculator;
import com.currencyexhange.currencyexchange.service.currencyconverter.CurrencyConverterService;
import com.currencyexhange.currencyexchange.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(BillingController.PATH)
public class BillingController {
    private final static Logger logger = LoggerFactory.getLogger(BillingController.class);
    public static final String PATH = "/api";

    @Autowired
    DiscountCalculator discountCalculator;

    @Autowired
    UserService userService;

    @Autowired
    CurrencyConverterService currencyConverter;

    @GetMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestBody Billing billing) {
        billing.setUser(userService.getUserByEmail(billing.getUserEmail()));
        double discountedAmount = discountCalculator.calculateFinalDiscount(billing);
        double exchangeRate =  currencyConverter.exchangeCurrency(billing.getOriginalCurrency(), billing.getTargetCurrency());
        double totalAmount = billing.getItems().stream()
                .mapToDouble(item -> item.getPrice())
                .sum();

        double finalAmount = (totalAmount-discountedAmount) * exchangeRate;
        return new ResponseEntity<>(finalAmount, HttpStatus.OK);
    }

}
