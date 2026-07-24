package com.franco.fintech.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Cliente no encontrado con id: " + id);
    }
}