package com.bookstore.customer_service.repository;

import com.bookstore.customer_service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
