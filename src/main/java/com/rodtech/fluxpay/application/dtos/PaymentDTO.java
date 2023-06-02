package com.rodtech.fluxpay.application.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expirationDate;
    private String securityCode;
    private BigDecimal amount;
    private String currency;
}
