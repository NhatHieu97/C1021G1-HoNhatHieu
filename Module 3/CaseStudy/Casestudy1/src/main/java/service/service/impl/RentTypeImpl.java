package service.service.impl;

import model.service.RentType;
import reponsitory.service.ServiceRentTypeRepository;
import service.service.IRentType;

import java.util.List;

public class RentTypeImpl implements IRentType {
    private ServiceRentTypeRepository serviceRentTypeRepository = new ServiceRentTypeRepository();
    @Override
    public List<RentType> findAll() {
        return serviceRentTypeRepository.findAll();
    }

    @Override
    public double getCostById(int id) {
        return serviceRentTypeRepository.getCodeById(id);
    }
}
