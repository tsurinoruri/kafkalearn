package com.example.order_service.ordermodel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "items", nullable = false)
    private String items;

    @Column(name = "quatity", nullable = false)
    private Integer quatity;
}
