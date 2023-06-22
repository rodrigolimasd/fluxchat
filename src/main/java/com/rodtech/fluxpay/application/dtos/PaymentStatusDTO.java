package com.rodtech.fluxpay.application.dtos;

import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatusDTO implements Serializable {
    private UUID id;
    private PaymentStatus paymentStatus;
}
