package com.example.casestudy.controller;

import com.example.casestudy.dto.customer.CustomerDto;
import com.example.casestudy.dto.employee.EmployeeDto;
import com.example.casestudy.model.person.UserName;
import com.example.casestudy.model.person.customer.Customer;
import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.repository.employee.IEmployeePositionRepository;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
import com.example.casestudy.service.employee.IEmployeeDividionService;
import com.example.casestudy.service.employee.IEmployeeEducationService;
import com.example.casestudy.service.employee.IEmployeePositionService;
import com.example.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public ModelAndView showListEmployee(@RequestParam(defaultValue = "") String search, @PageableDefault(value = 5)
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
        modelAndView.addObject("employeeDto", new EmployeeDto());
        modelAndView.addObject("employeeDividion",employeeDividionService.findAll());
        modelAndView.addObject("employeeEducation",employeeEducationService.findAll());
        modelAndView.addObject("employeePosition",employeePositionService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public String saveEmployee(@Valid EmployeeDto employeeDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("employeeDividion",employeeDividionService.findAll());
            model.addAttribute("employeeEducation",employeeEducationService.findAll());
            model.addAttribute("employeePosition",employeePositionService.findAll());
            return "/employee/create";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        }

        return ("redirect:/employee/list");

//        UserName userName1 = new UserName(userName,"123");
//        employee.setUserName(userName1);
//        employeeService.save(employee);
//        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
//        return ("redirect:/employee/list");
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employeeDividion",employeeDividionService.findAll());
        modelAndView.addObject("employeeEducation",employeeEducationService.findAll());
        modelAndView.addObject("employeePosition",employeePositionService.findAll());
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        employeeDto.setUserName(employee.getUserName().getUserName());
        model.addAttribute("employeeDto", employeeDto);
        return modelAndView;
//        Employee employee = employeeService.findById(id);
//        if (employee != null) {
//            ModelAndView modelAndView = new ModelAndView("/employee/edit");
//            modelAndView.addObject("employeeDividions",employeeDividionService.findAll());
//            modelAndView.addObject("employeeEducations",employeeEducationService.findAll());
//            modelAndView.addObject("employeePositions",employeePositionService.findAll());
//            modelAndView.addObject("employees", employee);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
    }

    @PostMapping("/edit-employee")
    public String updateEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("employeeDividion",employeeDividionService.findAll());
            model.addAttribute("employeeEducation",employeeEducationService.findAll());
            model.addAttribute("employeePosition",employeePositionService.findAll());
            return "/employee/edit";
        }else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Edit successfully");
        }
        return ("redirect:/employee/list");
    }
    @GetMapping("/delete-employee")
    public String delete(@RequestParam Long id , RedirectAttributes redirectAttributes){
        Employee employee= employeeService.findById(id);
        employeeService. remove(employee);
        redirectAttributes.addFlashAttribute("message","Xóa Thành Công");
        return "redirect:/employee/list";
    }
}
