package codegym.vn.case_study_module5_spring.model.employee;


import javax.persistence.*;

@Entity
public class Employee  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")

    private EmployeePosition employeePosition;

    @ManyToOne
    @JoinColumn(name="education_degree_id", referencedColumnName = "id")

    private EmployeeEducationDegree employeeEducationDegree;




    private Long salary;
    private Boolean gender;
    private String name;
    private String birthday;
    private String idCard;
    private String phone;
    private String email;
    private String address;


    public Employee() {
    }

    public Employee(Long id, EmployeePosition employeePosition, EmployeeEducationDegree employeeEducationDegree, Long salary, Boolean gender, String name, String birthday, String idCard, String phone, String email, String address) {
        this.id = id;
        this.employeePosition = employeePosition;
        this.employeeEducationDegree = employeeEducationDegree;
        this.salary = salary;
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idEmployee) {
        this.id = idEmployee;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public EmployeeEducationDegree getEmployeeEducationDegree() {
        return employeeEducationDegree;
    }

    public void setEmployeeEducationDegree(EmployeeEducationDegree employeeEducationDegree) {
        this.employeeEducationDegree = employeeEducationDegree;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
