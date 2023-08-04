package com.rodtech.fluxpay.adapter.out.repositories;

import com.rodtech.fluxpay.adapter.out.repositories.entities.PaymentEntity;
import com.rodtech.fluxpay.domain.models.payment.Payment;
import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentDataAdapterTest {

    @InjectMocks
    private PaymentDataAdapter paymentDataAdapter;

    @Mock
    private PaymentRepository paymentRepository;

    @Test
    void shouldSavePayment() {
        var payment = Payment.builder()
                .amount(BigDecimal.ONE)
                .currency("BRL")
                .description("teste")
                .status(PaymentStatus.PENDING)
                .build();
        var entityMock = PaymentEntity.builder()
                .id(UUID.randomUUID())
                .build();

        when(paymentRepository.save(any())).thenReturn(entityMock);

        var result = paymentDataAdapter.save(payment);

        assertNotNull(result.getId());
        assertEquals("BRL", payment.getCurrency());
        assertEquals("teste", payment.getDescription());

        verify(paymentRepository, times(1)).save(any());
    }


    @Test
    void shouldUpdatePaymentStatus() {
        var entityMock = PaymentEntity.builder()
                .id(UUID.randomUUID())
                .build();
        when(paymentRepository.findById(any())).thenReturn(Optional.of(entityMock));

        paymentDataAdapter.updateStatus(PaymentStatus.SUCCESSFUL, UUID.randomUUID());

        verify(paymentRepository, times(1)).findById(any());
        verify(paymentRepository, times(1)).save(any());

    }

    @Test
    void shouldGetByIdByPayment() {
        var entityMock = PaymentEntity.builder()
                .id(UUID.randomUUID())
                .amount(BigDecimal.ONE)
                .currency("BRL")
                .description("teste")
                .status(PaymentStatus.PENDING)
                .build();

        when(paymentRepository.findById(any())).thenReturn(Optional.of(entityMock));

        var result = paymentDataAdapter.getById(entityMock.getId());

        assertEquals(entityMock.getId(), result.getId());
        assertEquals(entityMock.getCurrency(), result.getCurrency());
        assertEquals(entityMock.getDescription(), result.getDescription());
        assertEquals(entityMock.getStatus(), result.getStatus());

        verify(paymentRepository, times(1)).findById(any());

    }
}