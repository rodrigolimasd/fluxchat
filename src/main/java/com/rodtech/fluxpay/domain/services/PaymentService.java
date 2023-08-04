package com.rodtech.fluxpay.domain.services;

import com.rodtech.fluxpay.domain.models.payment.Payment;
import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;

import java.util.UUID;

public interface PaymentService {
    Payment pay(Payment payment);

    Payment get(UUID id);

    void updateStatus(PaymentStatus status, UUID id);
}
