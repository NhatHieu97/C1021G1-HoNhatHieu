package codegym.vn.case_study_module5_spring.repository.employee;


import codegym.vn.case_study_module5_spring.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

}
