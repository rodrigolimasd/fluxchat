package com.rodtech.fluxpay.domain.model.payment;

import com.rodtech.fluxpay.domain.model.payment.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private UUID id;
    private BigDecimal amount;
    private String currency;
    private String source;
    private String description;
    private PaymentStatus status;
    private Card card;
}
