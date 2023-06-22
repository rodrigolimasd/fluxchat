package com.rodtech.fluxpay.domain.exceptions;

public class PaymentValidationException extends RuntimeException {
    public PaymentValidationException(String message) {
        super(message);
    }
}
