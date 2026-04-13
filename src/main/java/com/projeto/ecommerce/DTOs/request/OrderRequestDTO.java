package com.projeto.ecommerce.DTOs.request;

import com.projeto.ecommerce.enums.OrderStatus;

public record OrderRequestDTO(
        Long id,
        OrderStatus status) {
}
