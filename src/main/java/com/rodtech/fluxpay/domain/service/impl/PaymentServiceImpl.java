package com.rodtech.fluxpay.domain.service.impl;

import com.rodtech.fluxpay.domain.gateway.PaymentDataGateway;
import com.rodtech.fluxpay.domain.model.Payment;
import com.rodtech.fluxpay.domain.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDataGateway paymentDataGateway;

    public PaymentServiceImpl(PaymentDataGateway paymentDataGateway) {
        this.paymentDataGateway = paymentDataGateway;
    }

    @Override
    public Payment pay(Payment payment) {
        payment = paymentDataGateway.save(payment);
        return payment;
    }

    @Override
    public Payment get(UUID id) {
        return paymentDataGateway.getById(id);
    }
}
