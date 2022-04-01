package com.example.casestudy.controller;

import com.example.casestudy.dto.service.ServiceDto;
import com.example.casestudy.model.service.Service;
import com.example.casestudy.service.services.IRentTypeService;
import com.example.casestudy.service.services.IServiceTypeService;
import com.example.casestudy.service.services.IServicesService;
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
public class ServiceController {
    @Autowired
    private IServicesService servicesService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/service/list")
    public ModelAndView showListService(@RequestParam(defaultValue = "") String search, @PageableDefault(value = 5)
            Pageable pageable) {

        Page<Service> servicePage;
        if (search != null) {
            servicePage = servicesService.findByNameContaining(search, pageable);
        } else {
            servicePage = servicesService.findAll(pageable);
        }

        return new ModelAndView("service/list", "services", servicePage);
    }

    @GetMapping("/create-service-room")
    public ModelAndView showCreateFormRoom() {
        ModelAndView modelAndView = new ModelAndView("service/create-room");
        modelAndView.addObject("serviceDto", new ServiceDto());
        modelAndView.addObject("serviceTypes",serviceTypeService.findAll());
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-service-room")
    public String saveRoom(@Valid ServiceDto serviceDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new ServiceDto().validate(serviceDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("serviceTypes",serviceTypeService.findAll());
            model.addAttribute("rentTypes",rentTypeService.findAll());
            return "service/create-room";
        }else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto,service);
            servicesService.save(service);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        }

        return ("redirect:/service/list");
    }


    @GetMapping("/create-service-house")
    public ModelAndView showCreateFormHouse() {
        ModelAndView modelAndView = new ModelAndView("service/create-house");
        modelAndView.addObject("serviceDto", new ServiceDto());
        modelAndView.addObject("serviceTypes",serviceTypeService.findAll());
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-service-house")
    public String saveHouse(@Valid ServiceDto serviceDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new ServiceDto().validate(serviceDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("serviceTypes",serviceTypeService.findAll());
            model.addAttribute("rentTypes",rentTypeService.findAll());
            return "service/create-house";
        }else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto,service);
            servicesService.save(service);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        }

        return ("redirect:/service/list");
    }


    @GetMapping("/create-service-villa")
    public ModelAndView showCreateFormVilla() {
        ModelAndView modelAndView = new ModelAndView("service/create-villa");
        modelAndView.addObject("serviceDto", new ServiceDto());
        modelAndView.addObject("serviceTypes",serviceTypeService.findAll());
        modelAndView.addObject("rentTypes",rentTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-service-villa")
    public String saveVilla(@Valid ServiceDto serviceDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new ServiceDto().validate(serviceDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("serviceTypes",serviceTypeService.findAll());
            model.addAttribute("rentTypes",rentTypeService.findAll());
            return "service/create-villa";
        }else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto,service);
            servicesService.save(service);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        }

        return ("redirect:/service/list");
    }

//    @GetMapping("/edit-customer/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id, Model model, Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("customer/edit");
//        modelAndView.addObject("customerTypes", customerTypeService.findAll());
//        Customer customer = customerService.findById(id);
//        CustomerDto customerDto = new CustomerDto();
//        BeanUtils.copyProperties(customer, customerDto);
//        model.addAttribute("customerDto", customerDto);
//        return modelAndView;
////        Customer customer = customerService.findById(id);
////        if (customer != null) {
////            ModelAndView modelAndView = new ModelAndView("/customer/edit");
////            modelAndView.addObject("customerTypes",customerTypeService.findAll());
////            modelAndView.addObject("customer", customer);
////            return modelAndView;
////
////        } else {
////            ModelAndView modelAndView = new ModelAndView("/error.404");
////            return modelAndView;
////        }
//    }
//
//    @PostMapping("/edit-customer")
//    public String updateCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
//        if(bindingResult.hasErrors()){
//            model.addAttribute("customerType", customerTypeService.findAll());
//            return "/customer/edit";
//        }else {
//            Customer customer = new Customer();
//            BeanUtils.copyProperties(customerDto,customer);
//            customerService.save(customer);
//            redirectAttributes.addFlashAttribute("message", "Edit successfully");
//        }
//        return ("redirect:/customer/list");
//    }
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam Long id , RedirectAttributes redirectAttributes){
//        Customer customer1= customerService.findById(id);
//        if(customer1 != null){
//            customerService.remove(customer1);
//            redirectAttributes.addFlashAttribute("message","Xóa Thành Công");
//        }else {
//            redirectAttributes.addFlashAttribute("message","ID không tồn tại");
//        }
//        return "redirect:/customer/list";
//    }
}
