package com.rodtech.fluxpay.adapter.out.repositories.entities;

import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "varchar(255)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private String currency;
    private String description;
    @Column(nullable = false)
    private PaymentStatus status;
}
