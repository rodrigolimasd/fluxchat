package com.rodtech.fluxpay.adapter.in.web.controllers;

import com.rodtech.fluxpay.application.dtos.PaymentCreatedDTO;
import com.rodtech.fluxpay.application.dtos.PaymentDTO;
import com.rodtech.fluxpay.application.mappers.PaymentMapper;
import com.rodtech.fluxpay.domain.services.PaymentService;
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
    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    public ResponseEntity<PaymentCreatedDTO> pay(@RequestBody @Validated PaymentDTO paymentDTO) {
        log.info("creating new payment");
        var payment = paymentService.pay(paymentMapper.mapToModel(paymentDTO));
        log.info("payment created with success - paymentId: {}", payment.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMapper.mapToDTO(payment));
    }
}
