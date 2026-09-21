package com.example.order_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final AtomicInteger orderIdCounter;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.orderIdCounter = new AtomicInteger();
    }

    @PostMapping
    public void createOrder(@RequestBody Order order){
        log.info("Creating order: {}", order.toString());

        int orderId = orderIdCounter.incrementAndGet();

        var productName = order.product() + ThreadLocalRandom.current().nextInt(100);

        var orderToSave = new Order(
                Integer.toString(orderId),
                productName,
                order.quantuty()
        );

        orderService.saveOrder(order);
    }
}
