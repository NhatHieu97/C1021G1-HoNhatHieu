package service.employee;

import model.person.EmployeeEducationDegree;
import reponsitory.employee.EmployeeDivisionRepositoryImpl;
import reponsitory.employee.EmployeeEducationDegreeRepositoryImpl;

import java.util.List;

public class EmployEducationDegreeServiceImpl implements IEmployEducationDegreeServiceImpl {
    private EmployeeEducationDegreeRepositoryImpl employeeEducationDegreeRepository = new EmployeeEducationDegreeRepositoryImpl();
    @Override
    public List<EmployeeEducationDegree> findAll() {
        return employeeEducationDegreeRepository.findAll();
    }
}
