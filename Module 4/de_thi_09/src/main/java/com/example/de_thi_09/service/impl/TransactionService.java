package com.example.de_thi_09.service.impl;

import com.example.de_thi_09.model.Customer;
import com.example.de_thi_09.model.Transaction;
import com.example.de_thi_09.repository.TransactionRepository;
import com.example.de_thi_09.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Transaction findById(String maGiaoDich) {
        return transactionRepository.findById(maGiaoDich).orElse(null);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteById(String maGiaoDich) {
        transactionRepository.deleteById(maGiaoDich);
    }

    @Override
    public void remove(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    @Override
    public Page<Transaction> findByNameContaining(String name, Pageable pageable) {
        return transactionRepository.findAllByCustomer_TenKhachHangContaining(name, pageable);
    }

}
