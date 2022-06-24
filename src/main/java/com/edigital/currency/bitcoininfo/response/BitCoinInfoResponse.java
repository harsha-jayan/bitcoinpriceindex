package com.edigital.currency.bitcoininfo.response;

public class BitCoinInfoResponse {

    private float currentRate;
    private double lowestRate;
    private double highestRate;

    public double getLowestRate() {
        return lowestRate;
    }

    public void setLowestRate(double lowestRate) {
        this.lowestRate = lowestRate;
    }

    public double getHighestRate() {
        return highestRate;
    }

    public void setHighestRate(double highestRate) {
        this.highestRate = highestRate;
    }

    public float getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(float currentRate) {
        this.currentRate = currentRate;
    }

    public void setLowestRate(float lowestRate) {
        this.lowestRate = lowestRate;
    }

    public void setHighestRate(float highestRate) {
        this.highestRate = highestRate;
    }
}
