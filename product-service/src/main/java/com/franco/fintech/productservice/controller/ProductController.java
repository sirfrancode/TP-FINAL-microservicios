package com.franco.fintech.productservice.controller;

import com.franco.fintech.productservice.dto.ProductRequestDTO;
import com.franco.fintech.productservice.dto.ProductResponseDTO;
import com.franco.fintech.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(
            @RequestBody ProductRequestDTO requestDTO
    ) {
        ProductResponseDTO response = productService.create(requestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ProductResponseDTO>> findByCustomerId(
            @PathVariable Long customerId
    ) {
        return ResponseEntity.ok(
                productService.findByCustomerId(customerId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO requestDTO
    ) {
        return ResponseEntity.ok(
                productService.update(id, requestDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}