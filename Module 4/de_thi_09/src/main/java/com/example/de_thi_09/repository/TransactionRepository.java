package com.example.de_thi_09.repository;

import com.example.de_thi_09.model.Customer;
import com.example.de_thi_09.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
    Page<Transaction> findAllByCustomer_TenKhachHangContaining(String name, Pageable pageable);
}
