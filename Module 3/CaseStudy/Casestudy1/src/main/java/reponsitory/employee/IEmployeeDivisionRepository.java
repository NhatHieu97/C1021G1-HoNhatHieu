package reponsitory.employee;

import model.person.Customer;
import model.person.Employee;
import model.person.EmployeeDivision;

import java.util.List;

public interface IEmployeeDivisionRepository {
    List<EmployeeDivision> findAll();
}
