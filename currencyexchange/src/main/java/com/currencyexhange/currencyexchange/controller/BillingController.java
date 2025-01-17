package com.currencyexhange.currencyexchange.controller;

import com.currencyexhange.currencyexchange.model.Billing;
import com.currencyexhange.currencyexchange.service.DiscountCalculator;
import com.currencyexhange.currencyexchange.service.currencyconverter.CurrencyConverterService;
import com.currencyexhange.currencyexchange.service.user.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@Valid @RequestBody Billing billing) {
        billing.setUser(userService.getUserByEmail(billing.getUserEmail()));
        double discountedAmount = discountCalculator.calculateFinalDiscount(billing);
        double exchangeRate =  currencyConverter.exchangeCurrency(billing.getOriginalCurrency(), billing.getTargetCurrency());
        double totalAmount = billing.getItems().stream()
                .mapToDouble(item -> item.getPrice())
                .sum();

        double finalAmount = (totalAmount - discountedAmount) * exchangeRate;
        return new ResponseEntity<>(finalAmount, HttpStatus.OK);
    }

}
