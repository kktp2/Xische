package com.currencyexhange.currencyexchange.service.currencyconverter;

import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    private final IFeignClient feignClient;

    public CurrencyExchangeService(IFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public ExchangeRateResponse fetchExchangeRates(String baseCurrency) {
        return feignClient.getExchangeRates(baseCurrency);
    }
}
