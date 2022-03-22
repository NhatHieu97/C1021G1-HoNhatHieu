package com.example.casestudy.repository.customer;

import com.example.casestudy.model.person.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
