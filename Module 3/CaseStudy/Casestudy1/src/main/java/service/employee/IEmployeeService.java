package service.employee;

import model.person.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void create(Employee employee);
    void update(Employee employee);
    void delete(int id);
}
