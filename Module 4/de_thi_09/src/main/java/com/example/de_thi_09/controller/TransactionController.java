package com.example.de_thi_09.controller;

import com.example.de_thi_09.dto.TransactionDto;
import com.example.de_thi_09.model.Transaction;
import com.example.de_thi_09.service.impl.CustomerService;
import com.example.de_thi_09.service.impl.TransactionService;
import com.example.de_thi_09.service.impl.TransactionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TransactionController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/list")
    public ModelAndView showListTransaction(@RequestParam(name = "search",required = false,defaultValue = "") String search, @PageableDefault(value = 2)
            Pageable pageable) {
        Page<Transaction> transactionPage;
        if (search != null) {
            transactionPage = transactionService.findByNameContaining(search, pageable);
        } else {
            transactionPage = transactionService.findAll(pageable);
        }

        return new ModelAndView("list1", "transactionList", transactionPage);
    }

    @GetMapping("/create-transaction")
    public ModelAndView showCreateForm() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setMaGiaoDich(randomBorrowedNumber());
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("transactionDto", transactionDto);
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("transactionTypeList", transactionTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-transaction")
    public String saveTransaction(@Valid TransactionDto transactionDto, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes, Model model) {
        new TransactionDto().validate(transactionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("transactionTypeList", transactionTypeService.findAll());
            return "/create";
        } else {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(transactionDto, transaction);
            transactionService.save(transaction);
            redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        }

        return ("redirect:list");
    }

    @GetMapping("/view-transaction/{maGiaoDich}")
    public String readTransaction(@PathVariable String maGiaoDich, Model model) {
        model.addAttribute("transaction", transactionService.findById(maGiaoDich));
        return "vieww";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam String id,RedirectAttributes redirectAttributes) {
        transactionService.deleteById(id);
        redirectAttributes.addFlashAttribute("message","Xóa Thành Công");
        return "redirect:/list";
    }
    private int randomNumber(){
        int number = (int) Math.round(Math.random()*9);
        return number;
    }

    private String randomBorrowedNumber(){
        String result = "MGD-";
        for (int i = 0;i<4;i++){
            result +=randomNumber();
        }
        return result;
    }

}
