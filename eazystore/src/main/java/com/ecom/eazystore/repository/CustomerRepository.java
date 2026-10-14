package com.ecom.eazystore.repository;

import com.ecom.eazystore.entity.Customer;
import com.ecom.eazystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailOrMobileNumber(String email, String mobileNumber);
}