package com.franco.fintech.productservice.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        Long customerId,
        String name,
        String type,
        BigDecimal balance
) {
}