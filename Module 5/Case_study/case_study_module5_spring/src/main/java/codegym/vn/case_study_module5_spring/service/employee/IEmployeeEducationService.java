package codegym.vn.case_study_module5_spring.service.employee;


import codegym.vn.case_study_module5_spring.model.employee.EmployeeEducationDegree;

import java.util.List;

public interface IEmployeeEducationService {
    List<EmployeeEducationDegree> findAll();
}
