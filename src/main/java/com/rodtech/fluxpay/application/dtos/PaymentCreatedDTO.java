package com.rodtech.fluxpay.application.dtos;

import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreatedDTO {
    private UUID id;
    private BigDecimal amount;
    private String currency;
    private String description;
    private PaymentStatus paymentStatus;
}
