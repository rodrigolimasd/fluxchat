package com.rodtech.fluxpay.adapter.in.broken.consumers;

import com.rodtech.fluxpay.application.dtos.PaymentStatusDTO;
import com.rodtech.fluxpay.domain.models.payment.enums.PaymentStatus;
import com.rodtech.fluxpay.domain.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentConsumerTest {

    @InjectMocks
    private PaymentConsumer paymentConsumer;

    @Mock
    private PaymentService paymentService;

    @Test
    void shouldConsumerPaymentStatus() {
        var paymentDto = PaymentStatusDTO.builder()
                .id(UUID.randomUUID())
                .paymentStatus(PaymentStatus.SUCCESSFUL)
                .build();

        paymentConsumer.paymentConsumer(paymentDto, 1);

        verify(paymentService, times(1)).updateStatus(any(), any());

    }
}