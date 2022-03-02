package reponsitory.employee;

import model.person.Employee;
import model.person.EmployeePosition;

import java.util.List;

public interface IEmployeePositionRepository {
    List<EmployeePosition> findAll();
}
