package com.rodtech.fluxpay.domain.service;

import com.rodtech.fluxpay.domain.model.Payment;

import java.util.UUID;

public interface PaymentService {
    Payment pay(Payment payment);
    Payment get(UUID id);
}
