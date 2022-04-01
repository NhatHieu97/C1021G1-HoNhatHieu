package com.example.test_module4.service;

import com.example.test_module4.model.TransactionType;
import com.example.test_module4.repsository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService{
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Override
    public List<TransactionType> findAll() {
        return transactionTypeRepository.findAll();
    }
}
