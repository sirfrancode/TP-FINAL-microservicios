package com.franco.fintech.customerservice.dto;

import java.math.BigDecimal;

public record CustomerResponseDTO(
        Long id,
        String name,
        String document,
        String email,
        BigDecimal balance
) {
}