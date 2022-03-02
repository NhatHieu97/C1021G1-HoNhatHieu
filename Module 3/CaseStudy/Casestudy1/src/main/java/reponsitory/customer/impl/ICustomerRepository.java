package reponsitory.customer.impl;

import model.person.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    void create(Customer customer);
    void update(Customer customer);
    void delete(int id);
}
