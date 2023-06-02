package com.rodtech.fluxpay.adapter.in.web.controllers;

import com.rodtech.fluxpay.application.dtos.PaymentDTO;
import com.rodtech.fluxpay.domain.model.Payment;
import com.rodtech.fluxpay.domain.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public ResponseEntity<PaymentDTO> pay(@RequestBody @Validated PaymentDTO paymentDTO) {
        log.info("creating new payment");
        var payment = paymentService.pay(Payment.builder()
                .cardNumber(paymentDTO.getCardNumber())
                .cardHolderName(paymentDTO.getCardHolderName())
                .expirationDate(paymentDTO.getExpirationDate())
                .securityCode(paymentDTO.getSecurityCode())
                .amount(paymentDTO.getAmount())
                .currency(paymentDTO.getCurrency())
                .build());
        log.info("payment created with success - paymentId: {}", payment.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentDTO);
    }
}
