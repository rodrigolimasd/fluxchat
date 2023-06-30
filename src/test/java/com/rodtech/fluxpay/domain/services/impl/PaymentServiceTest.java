package com.rodtech.fluxpay.domain.services.impl;

import com.rodtech.fluxpay.domain.gateways.payment.PaymentDataGateway;
import com.rodtech.fluxpay.domain.gateways.payment.PaymentGateway;
import com.rodtech.fluxpay.domain.models.payment.Card;
import com.rodtech.fluxpay.domain.models.payment.Payment;
import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentGateway paymentGateway;

    @Mock
    private PaymentDataGateway paymentDataGateway;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Test
    void shouldProcessPaymentWithSuccessful() {
        var payment = getPayment();

        when(paymentGateway.getToken(any())).thenReturn(UUID.randomUUID().toString());
        when(paymentDataGateway.save(any())).thenReturn(payment);
        when(paymentGateway.pay(any())).thenReturn(true);

        var result = paymentService.pay(payment);

        assertEquals(PaymentStatus.SUCCESSFUL, result.getStatus());
        verify(paymentGateway, times(1)).getToken(any());
        verify(paymentDataGateway, times(2)).save(any());
        verify(paymentGateway, times(1)).pay(any());
    }

    @Test
    void shouldProcessPaymentWithFailed() {
        var payment = getPayment();

        when(paymentGateway.getToken(any())).thenReturn(UUID.randomUUID().toString());
        when(paymentDataGateway.save(any())).thenReturn(payment);
        when(paymentGateway.pay(any())).thenReturn(false);

        var result = paymentService.pay(payment);

        assertEquals(PaymentStatus.FAILED, result.getStatus());
        verify(paymentGateway, times(1)).getToken(any());
        verify(paymentDataGateway, times(2)).save(any());
        verify(paymentGateway, times(1)).pay(any());
    }

    @Test
    void shouldGetAPaymentById() {
        var id = UUID.randomUUID();
        var mockPayment = getPayment();
        mockPayment.setId(id);

        when(paymentDataGateway.getById(any())).thenReturn(mockPayment);

        var result = paymentService.get(id);

        assertEquals(id, result.getId());
    }

    @Test
    void shouldUpdateStarusWithSuccessful() {
        var id = UUID.randomUUID();
        var mockPayment = getPayment();
        mockPayment.setStatus(PaymentStatus.PENDING);
        when(paymentDataGateway.getById(any())).thenReturn(mockPayment);
        paymentService.updateStatus(PaymentStatus.SUCCESSFUL, id);

        verify(paymentDataGateway, times(1)).updateStatus(any(), any());
    }

    private Payment getPayment() {
        return Payment.builder()
                .card(Card.builder().build())
                .build();
    }

}