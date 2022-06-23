package com.edigital.currency.bitcoininfo.service;

import com.edigital.currency.bitcoininfo.client.BitCoinInfoClient;
import com.edigital.currency.bitcoininfo.response.BitCoinInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitCoinInfoService {

    private static final Logger log = LoggerFactory.getLogger(BitCoinInfoService.class);

    @Autowired
    private BitCoinInfoClient client;

    public BitCoinInfoResponse getDetails(String currency){
        try {
            float currentRate = client.getCurrentRate(currency);
            client.consumeHistoricalRates(currency);
            BitCoinInfoResponse response = new BitCoinInfoResponse();
            response.setCurrentRate(currentRate);
            return response;

        } catch (JsonProcessingException e) {
            log.error("Error while processing Json from public urls");
            throw new RuntimeException(e);
        }
    }


}
