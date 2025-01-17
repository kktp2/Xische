package com.currencyexhange.currencyexchange.controller;

import com.currencyexhange.currencyexchange.model.Billing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BillingController.PATH)
public class BillingController {
    private final static Logger logger = LoggerFactory.getLogger(BillingController.class);
    public static final String PATH = "/api";

    @GetMapping("/calculate")
    public ResponseEntity<Double> calculate(Billing billing) {


    }
}
