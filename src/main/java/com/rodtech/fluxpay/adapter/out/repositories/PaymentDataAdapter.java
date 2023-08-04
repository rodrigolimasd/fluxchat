package com.rodtech.fluxpay.adapter.out.repositories;

import com.rodtech.fluxpay.adapter.PaymentNotFoundException;
import com.rodtech.fluxpay.adapter.out.repositories.entities.PaymentEntity;
import com.rodtech.fluxpay.domain.gateways.payment.PaymentDataGateway;
import com.rodtech.fluxpay.domain.models.payment.Payment;
import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@Component
public class PaymentDataAdapter implements PaymentDataGateway {

    private final PaymentRepository paymentRepository;

    public PaymentDataAdapter(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        log.info("saving new payment - description: {}", payment.getDescription());
        var paymentEntity = PaymentEntity.builder()
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .description(payment.getDescription())
                .status(payment.getStatus())
                .build();

        paymentEntity = paymentRepository.save(paymentEntity);
        payment.setId(paymentEntity.getId());
        log.info("payment created - paymentId: {}", payment.getId());
        return payment;
    }

    @Override
    public void updateStatus(PaymentStatus paymentStatus, UUID id) {
        log.info("updating payment status - paymentId: {} - status: {}", id, paymentStatus.name());
        var paymentEntity = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("payment not found - paymentId: " + id));

        paymentEntity.setStatus(paymentStatus);
        paymentRepository.save(paymentEntity);
        log.info("payment status updated - paymentId: {} - status: {}", id, paymentStatus.name());
    }

    @Override
    public Payment getById(UUID id) {
        log.info("finding payment - paymentId: {}", id);
        return paymentRepository.findById(id)
                .map(p -> Payment.builder()
                        .id(p.getId())
                        .amount(p.getAmount())
                        .currency(p.getCurrency())
                        .description(p.getDescription())
                        .status(p.getStatus())
                        .build())
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found - paymentId: " + id));
    }
}
