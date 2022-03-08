package com.example.quan_ly_khach_hang_quan_ly_tinh.repository;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
