package com.example.de_thi_09.service.impl;

import com.example.de_thi_09.model.TransactionType;
import com.example.de_thi_09.repository.TransactionTypeRepository;
import com.example.de_thi_09.service.ITrangsactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionTypeService implements ITrangsactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;
    @Override
    public List<TransactionType> findAll() {
        return transactionTypeRepository.findAll();
    }
}
