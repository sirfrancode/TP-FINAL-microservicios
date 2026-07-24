package com.franco.fintech.customerservice.client;

import com.franco.fintech.customerservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products/customer/{customerId}")
    List<ProductDTO> findProductsByCustomerId(
            @PathVariable("customerId") Long customerId
    );
}