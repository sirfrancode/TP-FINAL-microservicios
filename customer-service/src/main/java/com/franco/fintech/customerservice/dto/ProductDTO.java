package com.franco.fintech.customerservice.dto;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        Long customerId,
        String name,
        String type,
        BigDecimal balance
) {
}
