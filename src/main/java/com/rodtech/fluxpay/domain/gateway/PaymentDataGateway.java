package com.rodtech.fluxpay.domain.gateway;

import com.rodtech.fluxpay.domain.model.Payment;

import java.util.UUID;

public interface PaymentDataGateway {
    Payment save(Payment payment);
    Payment getById(UUID id);
}
