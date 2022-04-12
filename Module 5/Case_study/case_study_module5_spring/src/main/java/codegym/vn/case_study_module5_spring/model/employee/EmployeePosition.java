package codegym.vn.case_study_module5_spring.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeePosition {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employeePosition", cascade = CascadeType.ALL)
    @Ignore
    private Set<Employee> employee;

    public EmployeePosition() {
    }

    public EmployeePosition(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long idPosition) {
        this.id = idPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String namePosition) {
        this.name = namePosition;
    }


}
