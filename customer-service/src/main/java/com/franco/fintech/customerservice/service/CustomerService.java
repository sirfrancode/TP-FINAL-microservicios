package com.franco.fintech.customerservice.service;

import com.franco.fintech.customerservice.dto.CustomerRequestDTO;
import com.franco.fintech.customerservice.dto.CustomerResponseDTO;
import com.franco.fintech.customerservice.entity.Customer;
import com.franco.fintech.customerservice.exception.CustomerNotFoundException;
import com.franco.fintech.customerservice.mapper.CustomerMapper;
import com.franco.fintech.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.franco.fintech.customerservice.client.ProductClient;
import com.franco.fintech.customerservice.dto.CustomerWithProductsDTO;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ProductClient productClient;

    public CustomerService(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper,
            ProductClient productClient
    ) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.productClient = productClient;
    }

    public CustomerResponseDTO create(CustomerRequestDTO requestDTO) {
        Customer customer = customerMapper.toEntity(requestDTO);
        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    public List<CustomerResponseDTO> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        return customerMapper.toResponse(customer);
    }

    public CustomerResponseDTO update(Long id, CustomerRequestDTO requestDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customerMapper.updateEntity(customer, requestDTO);

        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(updatedCustomer);
    }

    public void delete(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customerRepository.delete(customer);
    }

    public CustomerWithProductsDTO findByIdWithProducts(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        return new CustomerWithProductsDTO(
                customer.getId(),
                customer.getName(),
                customer.getDocument(),
                customer.getEmail(),
                customer.getBalance(),
                productClient.findProductsByCustomerId(id)
        );
    }

}