package service.service;

import model.service.RentType;

import java.util.List;

public interface IRentType {
    List<RentType> findAll();
    double getCostById(int id);
}
