package com.currencyexhange.currencyexchange.service.currencyconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyConverterService {
    @Autowired
    CurrencyExchangeService currencyExchangeService;

    public double exchangeCurrency(String originalCurrency, String targetCurrency){
        ExchangeRateResponse exchangeRates = currencyExchangeService.fetchExchangeRates(originalCurrency);
        Map<String, Double> conversionRates = exchangeRates.getConversion_rates();
        return conversionRates.get(targetCurrency);
    }
}
