package codegym.vn.case_study_module5_spring.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeeEducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employeeEducationDegree", cascade = CascadeType.ALL)
    @Ignore
    private Set<Employee> employee;

    public EmployeeEducationDegree() {
    }

    public EmployeeEducationDegree(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long idEducationDegree) {
        this.id = idEducationDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameEducationDegree) {
        this.name = nameEducationDegree;
    }


}
