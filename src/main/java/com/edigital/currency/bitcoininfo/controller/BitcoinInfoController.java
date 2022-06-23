package com.edigital.currency.bitcoininfo.controller;

import com.edigital.currency.bitcoininfo.response.BitCoinInfoResponse;
import com.edigital.currency.bitcoininfo.service.BitCoinInfoService;
import com.edigital.currency.bitcoininfo.util.UnSupportedCurrencyCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BitcoinInfoController {

    private static final Logger log = LoggerFactory.getLogger(BitcoinInfoController.class);

    @Autowired
    private BitCoinInfoService service;

    @GetMapping(value = "/details/{currency}")
    public ResponseEntity<BitCoinInfoResponse> getBitCoinInfo(@PathVariable("currency")  String currency){
        log.info("Get BTC details in "+currency);
        List<String> supportedCurrencies = new ArrayList<>(Arrays.asList("EUR", "USD", "INR", "GBP"));

        if(!supportedCurrencies.contains(currency.toUpperCase())) {
        log.error("Currency is not supported hence returning empty response");
        throw new UnSupportedCurrencyCodeException("Unsupported currency code, please provide currency codes of" +supportedCurrencies);
        }

        BitCoinInfoResponse response = service.getDetails(currency);
        log.debug("Successfully sending BTC details in "+currency);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
