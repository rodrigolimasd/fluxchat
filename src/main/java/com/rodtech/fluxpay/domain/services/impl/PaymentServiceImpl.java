package com.rodtech.fluxpay.domain.services.impl;

import com.rodtech.fluxpay.domain.gateways.payment.PaymentDataGateway;
import com.rodtech.fluxpay.domain.gateways.payment.PaymentGateway;
import com.rodtech.fluxpay.domain.models.payment.Payment;
import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import com.rodtech.fluxpay.domain.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDataGateway paymentDataGateway;
    private final PaymentGateway paymentGateway;

    public PaymentServiceImpl(PaymentDataGateway paymentDataGateway, PaymentGateway paymentGateway) {
        this.paymentDataGateway = paymentDataGateway;
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment pay(Payment payment) {
        var source = paymentGateway.getToken(payment.getCard());
        payment.setSource(source);
        payment.setStatus(PaymentStatus.PENDING);
        payment = paymentDataGateway.save(payment);

        var isPaySuccessful = paymentGateway.pay(payment);

        var status = isPaySuccessful ? PaymentStatus.SUCCESSFUL : PaymentStatus.FAILED;

        payment.setStatus(status);
        payment = paymentDataGateway.save(payment);

        return payment;
    }

    @Override
    public Payment get(UUID id) {
        return paymentDataGateway.getById(id);
    }
}
