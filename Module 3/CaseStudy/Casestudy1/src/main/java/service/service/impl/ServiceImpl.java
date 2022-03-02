package service.service.impl;

import model.service.Service;
import reponsitory.service.ServiceRepository;
import service.service.IService;

import java.util.List;

public class ServiceImpl implements IService {
    private ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void create(Service service) {
        serviceRepository.create(service);
    }
}
