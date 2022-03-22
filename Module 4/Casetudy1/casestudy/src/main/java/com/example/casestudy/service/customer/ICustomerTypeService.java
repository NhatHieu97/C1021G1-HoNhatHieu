package com.example.casestudy.service.customer;

import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.model.person.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
