package com.example.casestudy.controller;

import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.repository.employee.IEmployeePositionRepository;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
import com.example.casestudy.service.employee.IEmployeeDividionService;
import com.example.casestudy.service.employee.IEmployeeEducationService;
import com.example.casestudy.service.employee.IEmployeePositionService;
import com.example.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEmployeeDividionService employeeDividionService;

    @Autowired
    private IEmployeeEducationService employeeEducationService;

    @Autowired
    private IEmployeePositionService employeePositionService;


    @GetMapping("/employee/list")
    public ModelAndView showListCustomer(@RequestParam(defaultValue = "") String search, @PageableDefault(value = 5)
            Pageable pageable) {

        Page<Employee> employeePage;
        if (search != null) {
            employeePage = employeeService.findByNameContaining(search, pageable);
        } else {
            employeePage = employeeService.findAll(pageable);
        }

        return new ModelAndView("/employee/list", "employees", employeePage);
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("employeeDividion",employeeDividionService.findAll());
        modelAndView.addObject("employeeEducation",employeeEducationService.findAll());
        modelAndView.addObject("employeePosition",employeePositionService.findAll());
        return modelAndView;
    }
//
//    @PostMapping("/create-customer")
//    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
//        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
//        return ("redirect:/customer/list");
//    }
//
//    @GetMapping("/edit-customer/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("/customer/edit");
//            modelAndView.addObject("customerTypes",customerTypeService.findAll());
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-customer")
//    public String updateCustomer(@ModelAttribute Customer customer){
//        customerService.save(customer);
//        return ("redirect:/customer/list");
//    }
}
