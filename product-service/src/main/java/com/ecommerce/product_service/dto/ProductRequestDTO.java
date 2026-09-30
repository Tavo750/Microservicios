package com.ecommerce.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "El nombre del producto es obligatorio")
        String name,

        String description,

        @NotNull(message = "El precio del producto es obligatorio")
        @Positive(message = "El precio del producto debe ser un valor positivo")
        BigDecimal price
) {
}
