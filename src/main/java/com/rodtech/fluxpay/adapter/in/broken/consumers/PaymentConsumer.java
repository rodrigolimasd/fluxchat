package com.rodtech.fluxpay.adapter.in.broken.consumers;

import com.rodtech.fluxpay.application.dtos.PaymentStatusDTO;
import com.rodtech.fluxpay.application.util.JsonUtil;
import com.rodtech.fluxpay.domain.exceptions.PaymentValidationException;
import com.rodtech.fluxpay.domain.services.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Profile("!test")
@Log4j2
@Component
public class PaymentConsumer {

    private final PaymentService paymentService;

    public PaymentConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(groupId = "fluxpay", topics = "payments")
    public void paymentConsumer(String payload) {
        try {
            var payment = JsonUtil.fromJson(payload, PaymentStatusDTO.class);
            log.info("Consuming message - paymentId {} ", payment.getId());
            paymentService.updateStatus(payment.getPaymentStatus(), payment.getId());
            log.info("Message consumed - paymentId {} ", payment.getId());
        } catch (PaymentValidationException ex) {
            log.error(ex);
        } catch (Exception ex) {
            log.error(ex);
            throw ex;
        }

    }
}
