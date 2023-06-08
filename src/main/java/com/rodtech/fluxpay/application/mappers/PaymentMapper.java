package com.rodtech.fluxpay.application.mappers;

import com.rodtech.fluxpay.application.dtos.PaymentCreatedDTO;
import com.rodtech.fluxpay.application.dtos.PaymentDTO;
import com.rodtech.fluxpay.domain.models.payment.Card;
import com.rodtech.fluxpay.domain.models.payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment mapToModel(PaymentDTO paymentDTO) {
        return Payment.builder()
                .amount(paymentDTO.getAmount())
                .currency(paymentDTO.getCurrency())
                .description(paymentDTO.getDescription())
                .card(Card.builder()
                        .cardHolderName(paymentDTO.getCard().getCardHolderName())
                        .cardNumber(paymentDTO.getCard().getCardNumber())
                        .expirationMonth(paymentDTO.getCard().getExpirationMonth())
                        .expirationYear(paymentDTO.getCard().getExpirationYear())
                        .cvc(paymentDTO.getCard().getCvc())
                        .build())
                .build();
    }

    public PaymentCreatedDTO mapToDTO(Payment payment) {
        return PaymentCreatedDTO.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .description(payment.getDescription())
                .paymentStatus(payment.getStatus())
                .build();
    }
}
