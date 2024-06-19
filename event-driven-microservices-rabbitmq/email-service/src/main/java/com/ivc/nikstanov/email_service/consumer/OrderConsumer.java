package com.ivc.nikstanov.email_service.consumer;

import com.ivc.nikstanov.email_service.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderConsumer {

    @RabbitListener(queues = {"${spring.rabbitmq.email.queue.name}"})
    public void consume(OrderEvent orderEvent){
        log.info("Order event received -> {}", orderEvent.toString());
        // some operations with event
    }
}
