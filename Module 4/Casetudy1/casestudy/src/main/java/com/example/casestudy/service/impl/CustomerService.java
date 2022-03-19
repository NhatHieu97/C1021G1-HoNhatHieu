package com.example.casestudy.service.impl;

import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void save(Customer province) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void remove(Customer province) {

    }
}
