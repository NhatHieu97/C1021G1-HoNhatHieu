package reponsitory.service;

import model.person.Customer;
import model.service.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> findAll();
    void create(Service service);
}
