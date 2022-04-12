package codegym.vn.case_study_module5_spring.service.employee.impl;


import codegym.vn.case_study_module5_spring.model.employee.EmployeeEducationDegree;
import codegym.vn.case_study_module5_spring.repository.employee.IEmployeeEducationRepository;
import codegym.vn.case_study_module5_spring.service.employee.IEmployeeEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEducationService implements IEmployeeEducationService {
    @Autowired
    private IEmployeeEducationRepository iEmployeeEducationRepository;
    @Override
    public List<EmployeeEducationDegree> findAll() {
        return iEmployeeEducationRepository.findAll();
    }
}
