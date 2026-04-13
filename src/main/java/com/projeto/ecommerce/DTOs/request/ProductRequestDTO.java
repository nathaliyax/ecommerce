package com.projeto.ecommerce.DTOs.request;

public record ProductRequestDTO(
        Long id,
        String name,
        String description,
        double price,
        String imgUrl) {

}