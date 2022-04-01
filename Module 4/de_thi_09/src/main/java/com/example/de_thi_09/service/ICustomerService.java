package com.example.de_thi_09.service;

import com.example.de_thi_09.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Customer findById(String maKhachHang);

    void save(Customer customer);

    void deleteById(String maKhachHang);

    void remove(Customer customer);

    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
