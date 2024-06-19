package com.ivc.nikstanov.rabbitmq_tutorial.consumer;

import com.ivc.nikstanov.rabbitmq_tutorial.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(User message){
        log.info("Received message -> {}", message.toString());
    }

}
