package com.example.test_module4.service;

import com.example.test_module4.model.Customer;
import com.example.test_module4.model.Transaction;
import com.example.test_module4.repsository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public Page<Transaction> findByNameCustomer(String name, Pageable pageable) {
        return transactionRepository.findAllByCustomer_NameContaining(name,pageable);
    }

    @Override
    public Page<Transaction> findByNameCustomerAndTranSactionType(String name, String nameTransactionType, Pageable pageable) {
        return transactionRepository.findAllByCustomer_NameContainingAndTransactionType_Name(name,nameTransactionType,pageable);
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Transaction findById(int id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void remove(int id) {
        transactionRepository.deleteById(id);
    }
}
