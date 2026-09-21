package com.example.warehouser_service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderKafkaConsumer {

    //указываем какой топик слушаем
    @KafkaListener(topics = "orders")
    public void consumeOrder(ConsumerRecord<String, Order> record){

        log.info("Receive order={}, key={}, partition={}",record.value(), record.key(), record.partition());
    }
}
