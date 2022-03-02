package service.employee;

import model.person.EmployeeEducationDegree;

import java.util.List;

public interface IEmployEducationDegreeServiceImpl {
    List<EmployeeEducationDegree> findAll();
}
