package com.rodtech.fluxpay.adapter.in.broken.consumers;

import com.rodtech.fluxpay.application.dtos.PaymentStatusDTO;
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

    @KafkaListener(id="payment-consumer",
            topicPartitions = @TopicPartition(
                    topic = "payments",
                    partitions = { "0" },
                    partitionOffsets = {
                            @PartitionOffset(partition = "*", initialOffset = "0")}
            )
    )
    public void paymentConsumer(@Payload PaymentStatusDTO payment, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Consuming message from partition {} paymentId {} ", partition, payment.getId());
        paymentService.updateStatus(payment.getPaymentStatus(), payment.getId());
        log.info("Message consumed from partition {} paymentId {} ", partition, payment.getId());

    }
}
