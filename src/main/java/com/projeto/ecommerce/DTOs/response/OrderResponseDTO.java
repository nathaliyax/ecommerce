package com.projeto.ecommerce.DTOs.response;

import com.projeto.ecommerce.enums.OrderStatus;
import java.time.Instant;

public record OrderResponseDTO(
        Long id,
        Instant timestamp,
        OrderStatus status) {
}
