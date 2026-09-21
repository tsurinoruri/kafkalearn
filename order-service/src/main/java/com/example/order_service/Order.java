package com.example.order_service;

public record Order(
        String orderId,
        String product,
        Integer quantuty
) {
}
