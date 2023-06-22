package com.rodtech.fluxpay.application.dtos;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private BigDecimal amount;
    private String currency;
    private String description;
    private CardDTO card;
}
