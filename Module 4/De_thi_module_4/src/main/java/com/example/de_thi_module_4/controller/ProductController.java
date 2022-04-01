package com.example.de_thi_module_4.controller;

import com.example.de_thi_module_4.dto.ProducDto;
import com.example.de_thi_module_4.model.Product;
import com.example.de_thi_module_4.model.ProductType;
import com.example.de_thi_module_4.service.IProductService;
import com.example.de_thi_module_4.service.IProductTypeService;
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
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("/list")
    public ModelAndView showListTransaction(@RequestParam(name = "search",required = false,defaultValue = "") String search, @PageableDefault(value = 2)
            Pageable pageable) {
        Page<Product> productPage;
        if (search != null) {
            productPage = productService.findByNameContaining(search, pageable);
        } else {
            productPage = productService.findAll(pageable);
        }

        return new ModelAndView("list", "productList", productPage);
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ProducDto producDto = new ProducDto();
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productList", producDto);
        modelAndView.addObject("productTypeList", productTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveTransaction(@Valid ProducDto producDto, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes, Model model) {
        new ProducDto().validate(producDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypeList", productTypeService.findAll());
            return "/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(producDto, product);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        }

        return ("redirect:list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id, Model model, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("productTypes", productTypeService.findAll());
        Product product = productService.findById(id);
        ProducDto producDto = new ProducDto();
        BeanUtils.copyProperties(product, producDto);
        model.addAttribute("producDto", producDto);
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

    @PostMapping("/edit")
    public String updateCustomer(@Valid @ModelAttribute ProducDto producDto,BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("productTypes", productTypeService.findAll());
            return "/edit";
        }else {
            Product product = new Product();
            BeanUtils.copyProperties(producDto,product);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "Edit successfully");
        }
        return ("redirect:/list");
    }

}
