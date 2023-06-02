package com.rodtech.fluxpay.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private UUID id;
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expirationDate;
    private String securityCode;
    private BigDecimal amount;
    private String currency;
}
