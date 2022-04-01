package com.example.de_thi_09.service;

import com.example.de_thi_09.model.Customer;
import com.example.de_thi_09.model.TransactionType;

import java.util.List;

public interface ITrangsactionTypeService {
    List<TransactionType> findAll();
}
