package com.projeto.ecommerce.DTOs.request;

import com.projeto.ecommerce.enums.Role;

public record UserRequestDTO(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String password,
        Role role) {
}
