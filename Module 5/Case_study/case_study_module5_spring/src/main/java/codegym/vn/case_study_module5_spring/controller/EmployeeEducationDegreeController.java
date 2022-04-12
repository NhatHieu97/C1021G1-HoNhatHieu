package codegym.vn.case_study_module5_spring.controller;

import codegym.vn.case_study_module5_spring.model.employee.EmployeeEducationDegree;
import codegym.vn.case_study_module5_spring.model.employee.EmployeePosition;
import codegym.vn.case_study_module5_spring.service.employee.impl.EmployeeEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin("*")
public class EmployeeEducationDegreeController {

    @Autowired
    private EmployeeEducationService employeeEducationService;

    @RequestMapping(value = "/employeeEducationDegree", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeEducationDegree>> listAllEmployees() {
        List<EmployeeEducationDegree> employeeEducationDegreeList = employeeEducationService.findAll();
        if (employeeEducationDegreeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(employeeEducationDegreeList, HttpStatus.OK);
    }
}
