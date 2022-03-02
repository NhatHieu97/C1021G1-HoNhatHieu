package service.employee;

import model.person.EmployeePosition;

import java.util.List;

public interface IEmployeePositionService {
    List<EmployeePosition> findAll();
}
