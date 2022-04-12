package codegym.vn.case_study_module5_spring.service.employee;


import codegym.vn.case_study_module5_spring.model.employee.EmployeePosition;

import java.util.List;

public interface IEmployeePositionService {
    List<EmployeePosition> findAll();
}
