package reponsitory.service;

import model.service.RentType;
import model.service.Service;

import java.util.List;

public interface IServiceRentTypeRepository {
    List<RentType> findAll();
    double getCodeById(int id);
}
