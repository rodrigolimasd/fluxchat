package com.rodtech.fluxpay.domain.gateways.payment;

import com.rodtech.fluxpay.domain.models.payment.Payment;

import java.util.UUID;

public interface PaymentDataGateway {
    Payment save(Payment payment);
    Payment getById(UUID id);
}
