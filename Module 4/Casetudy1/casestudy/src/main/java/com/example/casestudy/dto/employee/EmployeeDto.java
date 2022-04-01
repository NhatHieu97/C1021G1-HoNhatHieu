package com.example.casestudy.dto.employee;

import com.example.casestudy.model.person.UserName;
import com.example.casestudy.model.person.employee.EmployeeDivision;
import com.example.casestudy.model.person.employee.EmployeeEducationDegree;
import com.example.casestudy.model.person.employee.EmployeePosition;
import com.example.casestudy.service.username.IUserNameService;
import com.example.casestudy.service.username.impl.UserNameService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;


public class EmployeeDto implements Validator {
    private Long idEmployee;
    private EmployeePosition employeePosition;
    private EmployeeDivision employeeDivision;
    private EmployeeEducationDegree employeeEducationDegree;

    private String userName;
    private Long salary;

    @NotBlank(message = "Họ tên không được để trống.")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10}|[\\p{Lu}]\\d*[\\p{Lu}]*|\\d*)){0,5}$",
            message = "Họ tên phải đúng định dạng.")
    private String name;

    @NotBlank(message = "Ngày sinh không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày sinh phải đúng định dạng: dd/MM/yyyy.")
    private String birthday;

    @NotBlank(message = "Số CMND không được để trống.")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Số CMND phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.")
    private String idCard;

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Số điện thoại phải đúng định dạng: 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;

    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
            message = "Email phải đúng định dạng.")
    private String email;

    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;
    private String code;

    public EmployeeDto() {
    }

    public EmployeeDto(Long idEmployee, EmployeePosition employeePosition, EmployeeDivision employeeDivision, EmployeeEducationDegree employeeEducationDegree, String userName, Long salary, String name, String birthday, String idCard, String phone, String email, String address, String code) {
        this.idEmployee = idEmployee;
        this.employeePosition = employeePosition;
        this.employeeDivision = employeeDivision;
        this.employeeEducationDegree = employeeEducationDegree;
        this.userName = userName;
        this.salary = salary;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.code = code;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public EmployeeDivision getEmployeeDivision() {
        return employeeDivision;
    }

    public void setEmployeeDivision(EmployeeDivision employeeDivision) {
        this.employeeDivision = employeeDivision;
    }

    public EmployeeEducationDegree getEmployeeEducationDegree() {
        return employeeEducationDegree;
    }

    public void setEmployeeEducationDegree(EmployeeEducationDegree employeeEducationDegree) {
        this.employeeEducationDegree = employeeEducationDegree;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
//        IUserNameService iUserNameService = new UserNameService();
//        List<UserName> userNames = iUserNameService.findAll();
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.getSalary() == null|| employeeDto.getSalary()< 0) {
            errors.rejectValue("salary", "", "Lương phải lớn hơn 0");
        }
//        for (UserName userName: userNames){
//            if (userName.equals(employeeDto.userName)){
//                errors.rejectValue("userName", "", "Tên user name đang bị trùng");
//            }
//        }
    }
}
