package service.customer.impl;

import model.person.Customer;
import reponsitory.customer.impl.ICustomerRepository;
import reponsitory.customer.impl.CustomerRepositoryImpl;
import service.customer.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepository.create(customer);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.update(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.delete(id);
    }
}
