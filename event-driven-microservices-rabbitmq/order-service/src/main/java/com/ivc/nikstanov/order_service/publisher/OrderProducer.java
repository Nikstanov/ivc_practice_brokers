package com.ivc.nikstanov.order_service.publisher;

import com.ivc.nikstanov.order_service.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.stock.queue.routing}")
    private String stockRoutingKey;

    @Value("${rabbitmq.email.queue.routing}")
    private String emailRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void send(OrderEvent orderEvent){
        log.info("Order event was sent to RabbitMQ -> {}", orderEvent.toString());
        rabbitTemplate.convertAndSend(exchangeName, stockRoutingKey, orderEvent);
        rabbitTemplate.convertAndSend(exchangeName, emailRoutingKey, orderEvent);
    }

}
