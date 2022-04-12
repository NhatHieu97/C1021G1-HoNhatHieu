package codegym.vn.case_study_module5_spring.service.employee;


import codegym.vn.case_study_module5_spring.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void deleteById(Long id);

    void remove(Long id);


}
