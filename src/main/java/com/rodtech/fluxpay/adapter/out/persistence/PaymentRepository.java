package com.rodtech.fluxpay.adapter.out.persistence;

import com.rodtech.fluxpay.adapter.out.persistence.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {

}
