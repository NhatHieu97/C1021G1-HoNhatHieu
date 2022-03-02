package service.customer;

import model.person.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void create(Customer customer);
    void update(Customer customer);
    void delete(int id);
}
