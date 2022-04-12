package codegym.vn.case_study_module5_spring.service.employee.impl;


import codegym.vn.case_study_module5_spring.model.employee.Employee;
import codegym.vn.case_study_module5_spring.repository.employee.IEmployeeRepository;
import codegym.vn.case_study_module5_spring.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public void remove(Long id) {
        iEmployeeRepository.deleteById(id);
    }


}
