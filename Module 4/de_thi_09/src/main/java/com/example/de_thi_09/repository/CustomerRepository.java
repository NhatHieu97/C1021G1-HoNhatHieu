package com.example.de_thi_09.repository;

import com.example.de_thi_09.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findByTenKhachHangContaining(String name, Pageable pageable);
}
