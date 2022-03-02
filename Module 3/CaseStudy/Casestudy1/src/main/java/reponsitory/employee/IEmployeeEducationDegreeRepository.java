package reponsitory.employee;

import model.person.Employee;
import model.person.EmployeeEducationDegree;

import java.util.List;

public interface IEmployeeEducationDegreeRepository {
    List<EmployeeEducationDegree> findAll();
}
