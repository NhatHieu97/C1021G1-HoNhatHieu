package codegym.vn.case_study_module5_spring.controller;

import codegym.vn.case_study_module5_spring.model.employee.Employee;
import codegym.vn.case_study_module5_spring.model.employee.EmployeePosition;
import codegym.vn.case_study_module5_spring.service.employee.impl.EmployeePositionService;
import codegym.vn.case_study_module5_spring.service.employee.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeePostionController {

    @Autowired
    private EmployeePositionService employeePosition;

    @RequestMapping(value = "/employeePosition", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeePosition>> listAllEmployees() {
        List<EmployeePosition> employeePositionList = employeePosition.findAll();
        if (employeePositionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>( employeePositionList, HttpStatus.OK);
    }
}
