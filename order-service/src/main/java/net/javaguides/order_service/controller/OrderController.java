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
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
          OrderEvent orderEvent = new OrderEvent();
          orderEvent.setStatus("PENDING");
          orderEvent.setMessage("order status is in pending state");
          orderEvent.setOrder(order);
          orderProducer.sendMessage(orderEvent);
          return "Order placed successfully...";
    }
}
