package com.ivc.nikstanov.orderservice.service;

import com.ivc.nikstanov.basedomain.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {


    @Value("${spring.kafka.topic.name}")
    private String topic;

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent event){
        log.info("Order event => {}", event.toString());
        kafkaTemplate.send(topic, event);
    }
}
