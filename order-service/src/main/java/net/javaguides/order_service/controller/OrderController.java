package net.javaguides.order_service.controller;

import net.javaguides.base_domains.model.Order;
import net.javaguides.base_domains.model.OrderEvent;
import net.javaguides.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
       return null;
    }
}
