package com.example.quan_ly_khach_hang_quan_ly_tinh.service.customer;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ICustomerService  {

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void deleteById(Long id);

    Page<Customer> findByFirstNameContaining(String name, Pageable pageable);
}
