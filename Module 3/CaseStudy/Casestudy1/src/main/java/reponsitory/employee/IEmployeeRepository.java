package reponsitory.employee;

import model.person.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    Employee findById(int id);
    void create(Employee employee);
    void update(Employee employee);
    void delete(int id);
}
