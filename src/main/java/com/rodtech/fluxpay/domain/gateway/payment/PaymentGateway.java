package com.rodtech.fluxpay.domain.gateway.payment;

import com.rodtech.fluxpay.domain.model.payment.Card;
import com.rodtech.fluxpay.domain.model.payment.Payment;

public interface PaymentGateway {
    boolean pay(Payment payment);
    String getToken(Card card);
}
