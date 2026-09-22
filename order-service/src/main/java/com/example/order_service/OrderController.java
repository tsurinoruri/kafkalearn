package com.example.order_service;

import com.example.order_service.ordermodel.Order;
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

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody Order order){
        log.info("Creating order: {}", order.toString());


        var productName = order.product() + ThreadLocalRandom.current().nextInt(100);

        var orderToSave = new Order(
                order.orderId(),
                productName,
                order.quantuty()
        );

        orderService.saveOrder(orderToSave);
    }
}
