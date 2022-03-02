package reponsitory.service;

import model.service.Service;
import model.service.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> findAll();


}
