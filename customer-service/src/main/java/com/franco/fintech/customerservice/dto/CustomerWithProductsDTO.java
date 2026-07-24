package com.franco.fintech.customerservice.dto;

import java.math.BigDecimal;
import java.util.List;

public record CustomerWithProductsDTO(
        Long id,
        String name,
        String document,
        String email,
        BigDecimal balance,
        List<ProductDTO> products
) {
}