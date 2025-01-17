package com.currencyexhange.currencyexchange.service.currencyconverter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currencyExchangeClient", url = "https://v6.exchangerate-api.com/v6/aa949c7b1eab7a3b1a71961f/latest/")
public interface IFeignClient {
    @GetMapping("/{baseCurrency}")
    ExchangeRateResponse getExchangeRates(@PathVariable("baseCurrency") String baseCurrency);
}

