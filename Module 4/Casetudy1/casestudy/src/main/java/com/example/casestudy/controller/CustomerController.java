package com.example.casestudy.controller;

import com.example.casestudy.dto.customer.CustomerDto;
import com.example.casestudy.model.person.customer.Customer;

import com.example.casestudy.model.person.employee.Employee;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
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
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping
    public String showList(){
        return "/list";
    }



    @GetMapping("/customer/list")
    public ModelAndView showListCustomer(@RequestParam(defaultValue = "") String search, @PageableDefault (value = 5)
                                         Pageable pageable) {

        Page<Customer> customerPage;
        if (search != null) {
            customerPage = customerService.findByNameContaining(search, pageable);
        } else {
            customerPage = customerService.findAll(pageable);
        }

        return new ModelAndView("/customer/list", "customers", customerPage);
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        modelAndView.addObject("customerType",customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@Valid CustomerDto customerDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("customerType",customerTypeService.findAll());
            return "/customer/create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        }

        return ("redirect:/customer/list");
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return modelAndView;
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
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@Valid @ModelAttribute CustomerDto customerDto,BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/edit";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Edit successfully");
        }
        return ("redirect:/customer/list");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id , RedirectAttributes redirectAttributes){
         Customer customer1= customerService.findById(id);
         if(customer1 != null){
             customerService.remove(customer1);
             redirectAttributes.addFlashAttribute("message","Xóa Thành Công");
         }else {
             redirectAttributes.addFlashAttribute("message","ID không tồn tại");
         }
        return "redirect:/customer/list";
    }
}
