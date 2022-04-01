package com.example.test_module4.service;


import com.example.test_module4.model.Customer;
import com.example.test_module4.model.Transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    Page<Transaction> findByNameCustomer(String name, Pageable pageable);
    Page<Transaction> findByNameCustomerAndTranSactionType(String name,String nameTransactionType, Pageable pageable);

    Page<Transaction> findAll(Pageable pageable);

    Transaction findById(int id);


    void save(Transaction transaction);

    void remove(int id);

}
