package vn.codegym.service;

import vn.codegym.model.Customer;

public interface ICustomerService {
    Customer findCustomerByName(String customerName);
}
