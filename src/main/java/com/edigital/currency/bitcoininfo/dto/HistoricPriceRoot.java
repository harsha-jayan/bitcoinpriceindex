package com.edigital.currency.bitcoininfo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoricPriceRoot {

    Map<String, Object> bpi;

    public Map<String, Object> getBpi() {
        return bpi;
    }

    public void setBpi(Map<String, Object> bpi) {
        this.bpi = bpi;
    }
}
