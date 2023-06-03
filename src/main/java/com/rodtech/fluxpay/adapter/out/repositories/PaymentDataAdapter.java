package com.rodtech.fluxpay.adapter.out.repositories;

import com.rodtech.fluxpay.domain.gateways.payment.PaymentDataGateway;
import com.rodtech.fluxpay.domain.models.payment.Payment;

import java.util.UUID;

public class PaymentDataAdapter implements PaymentDataGateway {
    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Override
    public Payment getById(UUID id) {
        return null;
    }
}
