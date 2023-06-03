package com.rodtech.fluxpay.adapter.out.repositories;

import com.rodtech.fluxpay.adapter.out.repositories.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {

}
