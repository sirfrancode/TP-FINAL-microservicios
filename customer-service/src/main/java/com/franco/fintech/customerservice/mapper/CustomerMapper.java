package com.franco.fintech.customerservice.mapper;

import com.franco.fintech.customerservice.dto.CustomerRequestDTO;
import com.franco.fintech.customerservice.dto.CustomerResponseDTO;
import com.franco.fintech.customerservice.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();

        customer.setName(dto.name());
        customer.setDocument(dto.document());
        customer.setEmail(dto.email());
        customer.setBalance(dto.balance());

        return customer;
    }

    public CustomerResponseDTO toResponse(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getDocument(),
                customer.getEmail(),
                customer.getBalance()
        );
    }

    public void updateEntity(Customer customer, CustomerRequestDTO dto) {
        customer.setName(dto.name());
        customer.setDocument(dto.document());
        customer.setEmail(dto.email());
        customer.setBalance(dto.balance());
    }
}