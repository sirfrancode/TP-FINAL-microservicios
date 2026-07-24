package com.franco.fintech.customerservice.controller;

import com.franco.fintech.customerservice.dto.CustomerRequestDTO;
import com.franco.fintech.customerservice.dto.CustomerResponseDTO;
import com.franco.fintech.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.franco.fintech.customerservice.dto.CustomerWithProductsDTO;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(
            @RequestBody CustomerRequestDTO requestDTO
    ) {
        CustomerResponseDTO response = customerService.create(requestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(
            @PathVariable Long id,
            @RequestBody CustomerRequestDTO requestDTO
    ) {
        return ResponseEntity.ok(
                customerService.update(id, requestDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        customerService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<CustomerWithProductsDTO> findByIdWithProducts(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                customerService.findByIdWithProducts(id)
        );
    }

}