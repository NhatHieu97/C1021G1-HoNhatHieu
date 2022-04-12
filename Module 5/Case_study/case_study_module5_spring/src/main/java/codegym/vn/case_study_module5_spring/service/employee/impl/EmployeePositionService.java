package codegym.vn.case_study_module5_spring.service.employee.impl;


import codegym.vn.case_study_module5_spring.model.employee.EmployeePosition;
import codegym.vn.case_study_module5_spring.repository.employee.IEmployeePositionRepository;
import codegym.vn.case_study_module5_spring.service.employee.IEmployeePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePositionService implements IEmployeePositionService {
    @Autowired
    private IEmployeePositionRepository employeePositionRepository;
    @Override
    public List<EmployeePosition> findAll() {
        return employeePositionRepository.findAll();
    }
}
