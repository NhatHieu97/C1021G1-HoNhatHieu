package service.employee;

import model.person.Employee;
import reponsitory.employee.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);

    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }
}
