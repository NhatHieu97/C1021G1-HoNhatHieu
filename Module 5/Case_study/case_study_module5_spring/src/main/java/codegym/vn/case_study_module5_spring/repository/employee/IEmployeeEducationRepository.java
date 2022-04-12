package codegym.vn.case_study_module5_spring.repository.employee;


import codegym.vn.case_study_module5_spring.model.employee.EmployeeEducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeEducationRepository extends JpaRepository<EmployeeEducationDegree,Long> {
}
