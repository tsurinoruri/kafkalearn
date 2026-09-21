package com.example.order_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderKafkaProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderKafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderToKafka(Order order){
        //1-topic, ключ или ключ-значение
        kafkaTemplate.send("orders",order.orderId(), order);
        log.info("Order send to kafka id={}", order.orderId());
    }
}
