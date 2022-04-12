package codegym.vn.case_study_module5_spring.controller;

import codegym.vn.case_study_module5_spring.model.employee.Employee;
import codegym.vn.case_study_module5_spring.service.employee.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employeeList = employeeService.findAll();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }



    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


//    @RequestMapping(value = "/employees", method = RequestMethod.POST)
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//        System.out.println(employee);
//        employeeService.save(employee);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addNew(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        System.out.println("Updating Employee " + id);

        Employee currentEmployee = employeeService.findById(id);

        if (currentEmployee == null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {

            employeeService.save(employee);
            return new ResponseEntity<>(currentEmployee, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            System.out.println("Unable to delete. Employee with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        employeeService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
