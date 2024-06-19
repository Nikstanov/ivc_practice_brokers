package com.ivc.nikstanov.rabbitmq_tutorial.pablisher;

import com.ivc.nikstanov.rabbitmq_tutorial.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqPublisher {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.name}")
    private String routing;

    private final RabbitTemplate rabbitTemplate;

    public void sendJson(User message){
        log.info("Message sent -> {}", message);
        rabbitTemplate.convertAndSend(exchange, routing, message);
    }

}
