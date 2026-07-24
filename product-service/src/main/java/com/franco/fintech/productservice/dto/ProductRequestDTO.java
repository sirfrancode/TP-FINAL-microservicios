package com.franco.fintech.productservice.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(
        Long customerId,
        String name,
        String type,
        BigDecimal balance
) {
}