package com.example.order_service;

import com.example.order_service.ordermodel.Order;
import com.example.order_service.ordermodel.OrderEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final OrderRepository orderRepository;

    public OrderMapper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order toOrder(OrderEntity entity){
        return new Order(
                entity.getId(),
                entity.getItems(),
                entity.getQuatity()
        );
    }

    public OrderEntity toEntity(Order order){
        OrderEntity entity = new OrderEntity();
        entity.setItems(order.product());
        entity.setQuatity(order.quantuty());
        return entity;
    }
}
