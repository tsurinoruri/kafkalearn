package com.example.order_service.ordermodel;

public record Order(
        Long orderId,
        String product,
        Integer quantuty
) {
}
