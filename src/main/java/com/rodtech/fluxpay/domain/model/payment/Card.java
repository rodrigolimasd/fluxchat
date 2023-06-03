package com.rodtech.fluxpay.domain.model.payment;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String cardHolderName;
    private String cardNumber;
    private Integer expirationMonth;
    private Integer expirationYear;
    private String cvc;
}
