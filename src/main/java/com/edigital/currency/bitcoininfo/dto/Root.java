package com.edigital.currency.bitcoininfo.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Root{
    public Bpi getBpi() {
        return bpi;
    }

    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }

    public String disclaimer;
    public Bpi bpi;
}






