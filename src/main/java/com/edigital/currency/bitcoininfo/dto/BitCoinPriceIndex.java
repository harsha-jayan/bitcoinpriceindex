package com.edigital.currency.bitcoininfo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitCoinPriceIndex {

    private Bpi bpi;
    private String disclaimer;

    public Bpi getBpi() {
        return bpi;
    }

    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }
}
