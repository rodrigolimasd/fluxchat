package com.rodtech.fluxpay.domain.gateway.payment;

import com.rodtech.fluxpay.domain.model.payment.Payment;

import java.util.UUID;

public interface PaymentDataGateway {
    Payment save(Payment payment);
    Payment getById(UUID id);
}
