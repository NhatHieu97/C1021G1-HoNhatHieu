package service.employee;

import model.person.EmployeePosition;
import reponsitory.employee.EmployeePositionRepositoryImpl;

import java.util.List;

public class EmployeePositionServiceImpl implements IEmployeePositionService {
    private EmployeePositionRepositoryImpl employeePositionRepository = new EmployeePositionRepositoryImpl();
    @Override
    public List<EmployeePosition> findAll() {
        return employeePositionRepository.findAll();
    }
}
