package service.customer.impl;

import model.person.CustomerType;
import reponsitory.customer.impl.ICustomerTypeRepository;
import reponsitory.customer.impl.CustomerTypeRepositoryImpl;
import service.customer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    private ICustomerTypeRepository iCustomerTypeRepository =new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
