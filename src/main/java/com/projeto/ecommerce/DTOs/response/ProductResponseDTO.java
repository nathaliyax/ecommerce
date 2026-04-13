package com.projeto.ecommerce.DTOs.response;

import jdk.jfr.Category;
import java.util.Set;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        double price,
        String imgUrl,
        Set<Category> categories) {

}
