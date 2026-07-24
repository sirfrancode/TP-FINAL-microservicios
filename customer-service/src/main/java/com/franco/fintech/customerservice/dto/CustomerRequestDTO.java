package com.franco.fintech.customerservice.dto;

import java.math.BigDecimal;

public record CustomerRequestDTO(
        String name,
        String document,
        String email,
        BigDecimal balance
) {
}