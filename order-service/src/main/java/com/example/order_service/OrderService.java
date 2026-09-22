package com.example.order_service;

import com.example.order_service.kafka.OrderKafkaProducer;
import com.example.order_service.ordermodel.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService {

    private final OrderKafkaProducer orderKafkaProducer;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Transactional
    public void saveOrder(Order order) {
        log.info("Saving to DB order={}", order);
        orderRepository.save(orderMapper.toEntity(order));
        orderKafkaProducer.sendOrderToKafka(order);
        log.info("Complete");
    }

}
