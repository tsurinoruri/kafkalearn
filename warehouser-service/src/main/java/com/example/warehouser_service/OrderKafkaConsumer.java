package com.example.warehouser_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderKafkaConsumer {

    //указываем какой топик слушаем
    @KafkaListener(topics = "orders")
    public void consumeOrder(Order order){
        log.info("Receive order");
    }
}
