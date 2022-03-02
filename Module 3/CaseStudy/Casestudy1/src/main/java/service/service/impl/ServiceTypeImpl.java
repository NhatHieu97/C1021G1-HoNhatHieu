package service.service.impl;

import reponsitory.service.ServiceTypeRepository;
import service.service.IServiceType;

import java.util.List;

public class ServiceTypeImpl implements IServiceType {
    private ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    @Override
    public List<model.service.ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

}
