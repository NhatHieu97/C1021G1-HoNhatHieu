package com.example.casestudy.service.services;

import com.example.casestudy.model.person.customer.CustomerType;
import com.example.casestudy.model.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
