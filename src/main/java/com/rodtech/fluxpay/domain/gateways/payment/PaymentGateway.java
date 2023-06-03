package com.rodtech.fluxpay.domain.gateways.payment;

import com.rodtech.fluxpay.domain.models.payment.Card;
import com.rodtech.fluxpay.domain.models.payment.Payment;

public interface PaymentGateway {
    boolean pay(Payment payment);
    String getToken(Card card);
}
