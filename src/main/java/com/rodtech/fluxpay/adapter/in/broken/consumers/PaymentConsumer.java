package com.rodtech.fluxpay.adapter.in.broken.consumers;

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

    @KafkaListener(id="payment-consumer",
            topicPartitions = @TopicPartition(
                    topic = "payments",
                    partitions = { "0" },
                    partitionOffsets = {
                            @PartitionOffset(partition = "*", initialOffset = "0")}
            )
    )
    public void paymentConsumer(@Payload String msg, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Message consumed from partition {} msg {} ", partition, msg);
    }
}
