package com.rodtech.fluxpay.application.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
    private String cardHolderName;
    private String cardNumber;
    private Integer expirationMonth;
    private Integer expirationYear;
    private String cvc;
}
