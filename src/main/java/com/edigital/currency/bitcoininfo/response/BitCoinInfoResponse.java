package com.edigital.currency.bitcoininfo.response;

public class BitCoinInfoResponse {

    private float currentRate;
    private float lowestRate;
    private float highestRate;

    public float getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(float currentRate) {
        this.currentRate = currentRate;
    }

    public float getLowestRate() {
        return lowestRate;
    }

    public void setLowestRate(float lowestRate) {
        this.lowestRate = lowestRate;
    }

    public float getHighestRate() {
        return highestRate;
    }

    public void setHighestRate(float highestRate) {
        this.highestRate = highestRate;
    }
}
