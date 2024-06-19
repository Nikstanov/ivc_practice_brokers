package com.ivc.nikstanov.order_service.controller;

import com.ivc.nikstanov.order_service.dto.Order;
import com.ivc.nikstanov.order_service.dto.OrderEvent;
import com.ivc.nikstanov.order_service.publisher.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody  Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent("PENDING", "Order is in pending status", order);
        orderProducer.send(orderEvent);
        return ResponseEntity.ok("Order was sent");
    }

}
