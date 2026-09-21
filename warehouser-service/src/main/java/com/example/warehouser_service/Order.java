package com.example.warehouser_service;

public record Order(
        String orderId,
        String productName,
        Integer quantity
) {
}
