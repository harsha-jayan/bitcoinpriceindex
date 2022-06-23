package com.edigital.currency.bitcoininfo.client;

import com.edigital.currency.bitcoininfo.dto.Bpi;
import com.edigital.currency.bitcoininfo.dto.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;

@Component
public class BitCoinInfoClient {

    private static final Logger log = LoggerFactory.getLogger(BitCoinInfoClient.class);

    @Value("${bpiCurrentRateApi}")
    String bpiCurrentRateUrl;

    @Value("${bpiHistoricRatesApi}")
    String bpiHistoricRatesUrl;

    public void consumeHistoricalRates(String currency) throws JsonProcessingException {
        String endDate = LocalDate.now().toString();
        String startDate = LocalDate.now().minusDays(30).toString();
        String uri = bpiHistoricRatesUrl+"start="+startDate+"&end="+endDate+"&currency="+currency;

        RestTemplate template = new RestTemplate();
        log.debug("Making call to the external api to fetch BTC historic prices from" +startDate +"till " +endDate);
        String json = template.getForObject(uri, String.class);
        log.debug("Successfully made call to the external api to fetch historic BTC prices");
        ObjectMapper om = new ObjectMapper();

/*        JSONPObject bpiObject = new JSONPObject(json).getFunction().
        JSONPObject root = om.readValue(json, JSONPObject.class);*/
    }

    public float getCurrentRate(String currency) throws JsonProcessingException {
        String uri = bpiCurrentRateUrl + currency +".json";
        RestTemplate template = new RestTemplate();

        log.debug("Making call to the external api to fetch BTC current price in "+currency);
        String json = template.getForObject(uri, String.class);
        log.debug("Successfully made to the external api to fetch BTC current price in "+currency);

        ObjectMapper om = new ObjectMapper();
        Root root = om.readValue(json, Root.class);
        Bpi bpi =  root.getBpi();

        return switch (currency) {
            case "eur" -> bpi.getEur().getRate_float();
            case "usd" -> bpi.getUsd().getRate_float();
            case "gbp" -> bpi.getGbp().getRate_float();
            case "inr" -> bpi.getInr().getRate_float();
            default -> 0.00F;
        };
    }
}
