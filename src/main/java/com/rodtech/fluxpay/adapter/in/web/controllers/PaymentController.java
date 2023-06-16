package com.rodtech.fluxpay.adapter.in.web.controllers;

import com.rodtech.fluxpay.application.dtos.PaymentCreatedDTO;
import com.rodtech.fluxpay.application.dtos.PaymentDTO;
import com.rodtech.fluxpay.application.mappers.PaymentMapper;
import com.rodtech.fluxpay.domain.services.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @Operation(summary = "Create a payment")
    @PostMapping
    public ResponseEntity<PaymentCreatedDTO> pay(@RequestBody @Validated PaymentDTO paymentDTO) {
        log.info("receiving payment");
        var payment = paymentService.pay(paymentMapper.mapToModel(paymentDTO));
        log.info("payment processed with successful - paymentId: {}", payment.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMapper.mapToDTO(payment));
    }

    @Operation(summary = "Get a payment by id")
    @GetMapping("/{id}")
    public ResponseEntity<PaymentCreatedDTO> get(@PathVariable UUID id) {
        log.info("receiving find payment");
        var payment = paymentMapper.mapToDTO(paymentService.get(id));
        log.info("payment found with successful - paymentId: {}", id);
        return ResponseEntity.ok(payment);
    }
}
