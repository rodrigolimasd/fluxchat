package com.rodtech.fluxpay.adapter.out.clients.stripe;

import com.rodtech.fluxpay.domain.gateways.payment.PaymentGateway;
import com.rodtech.fluxpay.domain.models.payment.Card;
import com.rodtech.fluxpay.domain.models.payment.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StripeGateway implements PaymentGateway {
    @Override
    public boolean pay(Payment payment) {
        //mock
        return true;
    }

    @Override
    public String getToken(Card card) {
        //mock
        return UUID.randomUUID().toString();
    }
}
