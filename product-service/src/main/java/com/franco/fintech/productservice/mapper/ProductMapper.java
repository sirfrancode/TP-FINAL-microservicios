package com.franco.fintech.productservice.mapper;

import com.franco.fintech.productservice.dto.ProductRequestDTO;
import com.franco.fintech.productservice.dto.ProductResponseDTO;
import com.franco.fintech.productservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();

        product.setCustomerId(dto.customerId());
        product.setName(dto.name());
        product.setType(dto.type());
        product.setBalance(dto.balance());

        return product;
    }

    public ProductResponseDTO toResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getCustomerId(),
                product.getName(),
                product.getType(),
                product.getBalance()
        );
    }

    public void updateEntity(Product product, ProductRequestDTO dto) {
        product.setCustomerId(dto.customerId());
        product.setName(dto.name());
        product.setType(dto.type());
        product.setBalance(dto.balance());
    }
}