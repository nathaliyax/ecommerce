package com.projeto.ecommerce.DTOs;

import java.time.Instant;

public record PaymentDTO(
        Long id,
        Instant timestamp) {
}