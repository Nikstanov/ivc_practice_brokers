package com.ivc.nikstanov.rabbitmq_tutorial.controller;

import com.ivc.nikstanov.rabbitmq_tutorial.dto.User;
import com.ivc.nikstanov.rabbitmq_tutorial.pablisher.RabbitMqPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMqPublisher rabbitMqPublisher;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user){
        rabbitMqPublisher.sendJson(user);
        return ResponseEntity.ok("Message was sent");
    }
}
