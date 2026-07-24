package com.franco.fintech.productservice.service;

import com.franco.fintech.productservice.dto.ProductRequestDTO;
import com.franco.fintech.productservice.dto.ProductResponseDTO;
import com.franco.fintech.productservice.entity.Product;
import com.franco.fintech.productservice.exception.ProductNotFoundException;
import com.franco.fintech.productservice.mapper.ProductMapper;
import com.franco.fintech.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(
            ProductRepository productRepository,
            ProductMapper productMapper
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponseDTO create(ProductRequestDTO requestDTO) {
        Product product = productMapper.toEntity(requestDTO);
        Product savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    public ProductResponseDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return productMapper.toResponse(product);
    }

    public List<ProductResponseDTO> findByCustomerId(Long customerId) {
        return productRepository.findByCustomerId(customerId)
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO requestDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productMapper.updateEntity(product, requestDTO);

        Product updatedProduct = productRepository.save(product);

        return productMapper.toResponse(updatedProduct);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.delete(product);
    }
}