package com.rodtech.fluxpay.domain.gateways.payment;

import com.rodtech.fluxpay.domain.models.payment.Payment;
import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;

import java.util.UUID;

public interface PaymentDataGateway {
    Payment save(Payment payment);

    void updateStatus(PaymentStatus paymentStatus, UUID id);

    Payment getById(UUID id);
}
