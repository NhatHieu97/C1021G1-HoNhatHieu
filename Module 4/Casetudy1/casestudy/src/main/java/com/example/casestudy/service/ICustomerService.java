package com.example.casestudy.service;

import com.example.casestudy.model.person.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer province);

    void deleteById(Long id);

    void remove(Customer province);
}
