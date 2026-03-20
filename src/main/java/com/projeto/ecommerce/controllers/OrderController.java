package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTOs.OrderDTO;
import com.projeto.ecommerce.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO dto) {

        OrderDTO newOrder = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }
}