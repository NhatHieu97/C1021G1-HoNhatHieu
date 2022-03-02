package service.employee;

import model.person.EmployeeDivision;
import reponsitory.employee.EmployeeDivisionRepositoryImpl;

import java.util.List;

public class EmployeeDivisionServiceImpl implements IEmployeeDivisionService {
    private EmployeeDivisionRepositoryImpl employeeDivisionRepository = new EmployeeDivisionRepositoryImpl();
    @Override
    public List<EmployeeDivision> findAll() {
        return employeeDivisionRepository.findAll();
    }
}
