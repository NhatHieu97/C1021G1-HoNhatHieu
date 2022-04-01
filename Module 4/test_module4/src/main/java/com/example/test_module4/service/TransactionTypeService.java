package com.example.test_module4.service;

import com.example.test_module4.model.Customer;
import com.example.test_module4.model.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionTypeService {
    List<TransactionType> findAll();
}
