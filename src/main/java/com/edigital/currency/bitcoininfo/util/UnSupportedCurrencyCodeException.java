package com.edigital.currency.bitcoininfo.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnSupportedCurrencyCodeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UnSupportedCurrencyCodeException(String message) {
        super(message);
    }
}
