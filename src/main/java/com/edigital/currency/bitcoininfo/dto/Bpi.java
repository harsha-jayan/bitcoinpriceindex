package com.edigital.currency.bitcoininfo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bpi {

        @JsonProperty("USD")
        private Currency usd;
        @JsonProperty("EUR")
        private Currency eur;

        @JsonProperty("GBP")
        private Currency gbp;

        @JsonProperty("INR")
        private Currency inr;

        public Currency getUsd() {
                return usd;
        }
        public void setUsd(Currency usd) {
                this.usd = usd;
        }

        public Currency getEur() {
                return eur;
        }

        public void setEur(Currency eur) {
                this.eur = eur;
        }

        public Currency getGbp() {
                return gbp;
        }

        public void setGbp(Currency gbp) {
                this.gbp = gbp;
        }

        public Currency getInr() {
                return inr;
        }

        public void setInr(Currency inr) {
                this.inr = inr;
        }
}
