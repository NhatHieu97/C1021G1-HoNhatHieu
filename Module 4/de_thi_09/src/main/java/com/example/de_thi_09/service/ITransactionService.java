package com.example.de_thi_09.service;

import com.example.de_thi_09.model.Customer;
import com.example.de_thi_09.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITransactionService {
    List<Transaction> findAll();

    Page<Transaction> findAll(Pageable pageable);

    Transaction findById(String maGiaoDich);

    void save(Transaction transaction);

    void deleteById(String maGiaoDich);

    void remove(Transaction transaction);

    Page<Transaction> findByNameContaining(String name, Pageable pageable);

}
