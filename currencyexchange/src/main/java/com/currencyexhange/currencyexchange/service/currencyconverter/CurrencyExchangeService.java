package com.currencyexhange.currencyexchange.service.currencyconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    private IFeignClient feignClient;

    public ExchangeRateResponse fetchExchangeRates(String baseCurrency) {
        return feignClient.getExchangeRates(baseCurrency);
    }
}
