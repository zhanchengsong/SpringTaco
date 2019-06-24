package ninja.zhancheng.tacospring.Messaging;

import lombok.extern.slf4j.Slf4j;
import ninja.zhancheng.tacospring.Domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaOrderMessagingService implements OrderMessagingService {
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public void sendOrder(Order order) {
        log.info("Sending Kafka msg: {}",order);
        kafkaTemplate.send("tacocloud.orders.topic",order);
    }
}
