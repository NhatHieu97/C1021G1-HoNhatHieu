package com.example.casestudy.controller;

import com.example.casestudy.model.person.customer.Customer;

import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerType",customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return ("redirect:/customer/list");
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customerTypes",customerTypeService.findAll());
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return ("redirect:/customer/list");
    }
}
