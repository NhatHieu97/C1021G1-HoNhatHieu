package com.example.casestudy.service.services;

import com.example.casestudy.model.person.customer.CustomerType;
import com.example.casestudy.model.service.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
