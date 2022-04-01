package com.example.test_module4.controller;

import com.example.test_module4.dto.TransactionDto;
import com.example.test_module4.model.Customer;
import com.example.test_module4.model.Transaction;
import com.example.test_module4.model.TransactionType;
import com.example.test_module4.service.CustomerService;
import com.example.test_module4.service.TransactionService;
import com.example.test_module4.service.TransactionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionTypeService transactionTypeService;


    @GetMapping("/list")
    public ModelAndView listCustomers(@RequestParam(name = "search", defaultValue = "") String name,
                                      @RequestParam(name = "transactionTypes", defaultValue = "") String transactionTypesName,
                                      @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = null;

        if (transactionTypesName.equals("")) {
            Page<Transaction> transactions = transactionService.findByNameCustomer(name,pageable);
            modelAndView = new ModelAndView("transaction/index");
            modelAndView.addObject("searchName",name);
            modelAndView.addObject("transactions", transactions);
        } else {
            Page<Transaction> transactions =transactionService.findByNameCustomerAndTranSactionType(name, transactionTypesName, pageable);
                    modelAndView = new ModelAndView("transaction/index", "transactions",transactions);
            modelAndView.addObject("searchName",name);
            modelAndView.addObject("searchTypeTransaction",transactionTypesName);
        }
        //        Gửi hiển thị list typelist sang trang index
        List<TransactionType> transactionTypes = transactionTypeService.findAll();
        modelAndView.addObject("transactionTypes", transactionTypes);
        return modelAndView;

    }

    @GetMapping("/search/{id}")
    public ModelAndView searhById(@PathVariable int id) {
        Transaction transaction = transactionService.findById(id);
        ModelAndView modelAndView = new ModelAndView("transaction/view");
        modelAndView.addObject("transaction", transaction);
        return modelAndView;
    }

//    @RequestMapping("/searchByName")
//    public ModelAndView searchByNameCustomer(@RequestParam(name = "search") String name, @RequestParam(name = "transactionTypes") String transactionTypesName, @PageableDefault(value = 2,
//            sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("transaction/index", "transactions", transactionService.findByNameCustomerAndTranSactionType(name, transactionTypesName, pageable));
//        //        Gửi hiển thị list typelist sang trang index
//        Page<TransactionType> transactionTypes = transactionTypeService.findAll(pageable);
//        modelAndView.addObject("transactionTypes", transactionTypes);
//        return modelAndView;
//    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("transaction/create");
        List<TransactionType> transactionTypes = transactionTypeService.findAll();
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("transactionTypes", transactionTypes);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("transactionDto", new TransactionDto());
        return modelAndView;
    }


    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute(name = "transactionDto") TransactionDto transactionDto, BindingResult bindingResult, @PageableDefault(value = 5, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            List<TransactionType> transactionTypes = transactionTypeService.findAll();
            List<Customer> customers = customerService.findAll();
            model.addAttribute("transactionTypes", transactionTypes);
            model.addAttribute("customers", customers);
            return "transaction/create";
        } else {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(transactionDto, transaction);
            transactionService.save(transaction);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
            return "redirect:/transaction/list";
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id, Pageable pageable) {
        if (transactionService.findById(id) != null) {
            ModelAndView modelAndView = new ModelAndView("transaction/edit");
            List<TransactionType> transactionTypes = transactionTypeService.findAll();
            List<Customer> customers = customerService.findAll();
            modelAndView.addObject("transactionTypes", transactionTypes);
            modelAndView.addObject("customers", customers);

            modelAndView.addObject("transaction", transactionService.findById(id));
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute(name = "transaction") Transaction transaction, Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
        transactionService.save(transaction);
        redirectAttributes.addFlashAttribute("message", "New customer edited successfully");
        return "redirect:/transaction/list";
    }


    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "id") int id,RedirectAttributes redirectAttributes) {
        transactionService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/transaction/list";
    }
}
