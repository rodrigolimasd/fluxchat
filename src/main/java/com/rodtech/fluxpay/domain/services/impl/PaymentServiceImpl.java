package com.rodtech.fluxpay.domain.services.impl;

import com.rodtech.fluxpay.domain.exceptions.PaymentValidationException;
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

        var processing = paymentGateway.pay(payment);

        var status = processing ? PaymentStatus.PROCESSING : PaymentStatus.FAILED;

        payment.setStatus(status);
        payment = paymentDataGateway.save(payment);

        return payment;
    }

    @Override
    public Payment get(UUID id) {
        return paymentDataGateway.getById(id);
    }

    @Override
    public void updateStatus(PaymentStatus status, UUID id) {
        var payment = paymentDataGateway.getById(id);

        validateStatus(payment, status);
        payment.setStatus(status);
        paymentDataGateway.updateStatus(status, id);
    }

    private void validateStatus(Payment payment, PaymentStatus status) {
        if(payment.getStatus()!=PaymentStatus.PENDING) {
            throw new PaymentValidationException("Invalid update status - paymentId: "+payment.getId());
        }
        if(status==PaymentStatus.PENDING) {
            throw new PaymentValidationException("Invalid status - status: "+ status);
        }
    }
}
