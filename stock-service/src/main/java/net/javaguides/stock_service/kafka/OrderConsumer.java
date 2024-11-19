package net.javaguides.stock_service.kafka;

import net.javaguides.base_domains.model.Order;
import net.javaguides.base_domains.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event) {
        logger.info("Order event stock => : " + event.toString());
    }
}
