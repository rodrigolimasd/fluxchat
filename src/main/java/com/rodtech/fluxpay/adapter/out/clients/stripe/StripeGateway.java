package com.rodtech.fluxpay.adapter.out.clients.stripe;

import com.rodtech.fluxpay.domain.gateways.payment.PaymentGateway;
import com.rodtech.fluxpay.domain.models.payment.Card;
import com.rodtech.fluxpay.domain.models.payment.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@Component
public class StripeGateway implements PaymentGateway {
    @Override
    public boolean pay(Payment payment) {
        log.info("retrieve a gateway payment");
        //mock
        return true;
    }

    @Override
    public String getToken(Card card) {
        log.info("retrieve a card token");
        //mock
        return UUID.randomUUID().toString();
    }
}
