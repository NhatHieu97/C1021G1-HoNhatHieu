package com.example.quan_ly_khach_hang_quan_ly_tinh.service.customer.impl;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Customer;
import com.example.quan_ly_khach_hang_quan_ly_tinh.repository.ICustomerRepository;
import com.example.quan_ly_khach_hang_quan_ly_tinh.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByFirstNameContaining(String name, Pageable pageable) {
        return customerRepository.findByFirstNameContaining(name, pageable);
    }
}
