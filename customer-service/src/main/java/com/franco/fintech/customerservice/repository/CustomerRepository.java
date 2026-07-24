package com.franco.fintech.customerservice.repository;

import com.franco.fintech.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByDocument(String document);

    Optional<Customer> findByEmail(String email);
}