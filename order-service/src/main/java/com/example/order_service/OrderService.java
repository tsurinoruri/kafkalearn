package com.example.order_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    private final OrderKafkaProducer orderKafkaProducer;

    public OrderService(OrderKafkaProducer orderKafkaProducer) {
        this.orderKafkaProducer = orderKafkaProducer;
    }

    public void saveOrder(Order order) {
        log.info("Saving to DB order={}", order);
        orderKafkaProducer.sendOrderToKafka(order);
        log.info("Complete");
    }

}
