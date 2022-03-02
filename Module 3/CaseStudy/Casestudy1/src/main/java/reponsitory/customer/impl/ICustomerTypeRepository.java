package reponsitory.customer.impl;

import model.person.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> findAll();
}
