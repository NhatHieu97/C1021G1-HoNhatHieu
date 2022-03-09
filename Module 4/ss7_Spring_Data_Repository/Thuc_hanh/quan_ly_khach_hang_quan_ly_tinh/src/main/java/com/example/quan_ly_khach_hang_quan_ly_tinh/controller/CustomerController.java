package com.example.quan_ly_khach_hang_quan_ly_tinh.controller;

import com.example.quan_ly_khach_hang_quan_ly_tinh.model.Customer;
import com.example.quan_ly_khach_hang_quan_ly_tinh.service.customer.ICustomerService;
import com.example.quan_ly_khach_hang_quan_ly_tinh.service.provice.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProvinceService proviceService;


    @GetMapping
    public ModelAndView listCustomer(@RequestParam(defaultValue = "") String search, @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customerPage;
        if (search != null) {
            customerPage = customerService.findByFirstNameContaining(search, pageable);
        } else {
            customerPage = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list", "customers", customerPage);

        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces",proviceService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return ("redirect:/");
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("provinces",proviceService.findAll());
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
        return ("redirect:/");
    }

    @GetMapping("/delete-customer/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "/customer/delete";
    }

    @PostMapping("/delete-customer")
    public String delete(@RequestParam Long id){
        customerService.deleteById(id);
        return "redirect:/";
    }

}
