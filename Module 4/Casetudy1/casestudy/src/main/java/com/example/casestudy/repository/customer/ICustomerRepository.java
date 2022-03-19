package com.example.casestudy.repository.customer;

import com.example.casestudy.model.person.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
