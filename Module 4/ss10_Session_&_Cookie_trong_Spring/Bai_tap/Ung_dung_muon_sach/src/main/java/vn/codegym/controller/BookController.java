package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Book;
import vn.codegym.model.BorrowedBook;
import vn.codegym.model.Customer;
import vn.codegym.service.IBookService;
import vn.codegym.service.IBorrowedBookService;
import vn.codegym.service.ICustomerService;
@Controller
public class BookController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    IBookService bookService;
    @Autowired
    IBorrowedBookService borrowedBookService;

    @RequestMapping
    public ModelAndView displayHome(@PageableDefault(size = 5) Pageable pageable){
        Page<Book> bookPage = bookService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("book/list","bookList",bookPage);
        return modelAndView;
    }
    @GetMapping("/add-book")
    public String showFormAdd( Model model){
        model.addAttribute("book",new Book());
        return "book/addBook";
    }
    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book){
        book.setCurrentQuantity(book.getQuantity());
        bookService.save(book);
        return "redirect:/";
    }
    @GetMapping("borrow-book")
    public String showFormBorrow(@RequestParam Long id, RedirectAttributes redirectAttributes, Model model){
        Book book = bookService.findById(id);
        if(book != null){
            if(book.getCurrentQuantity()>0){
                model.addAttribute("book",book);
                return "book/borrowBook";
            }else {
                throw new NumberFormatException("");
            }
        }
        return "redirect:/";
    }
    @PostMapping("borrow-book")
    public String borrowBook(@ModelAttribute Book book,@RequestParam String customerName, RedirectAttributes redirectAttributes){
        book.setCurrentQuantity(book.getCurrentQuantity()-1);
        Customer customerId = customerService.findCustomerByName(customerName);
        BorrowedBook borrowedBook = new BorrowedBook(randomBorrowedNumber(),book,customerId);
        borrowedBookService.save(borrowedBook);
        redirectAttributes.addFlashAttribute("message","Bạn đã mượn thành công sách");
        bookService.save(book);
        return "redirect:/";
    }
    @GetMapping("pay-book")
    public String showFormPayBook(){
        return "book/payBook";
    }

    @PostMapping("pay-book")
    public String payBook(@RequestParam String number,RedirectAttributes redirectAttributes) throws Exception {
        BorrowedBook borrowedBook = borrowedBookService.findByborrowedNumber(number);
        if(borrowedBook==null){
            throw  new NullPointerException("");
        }else {
            Long bookId = borrowedBook.getBook().getId();
            Book book = bookService.findById(bookId);
            book.setCurrentQuantity(book.getCurrentQuantity()+1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("message","đã trả sách thành công");
            borrowedBookService.delete(borrowedBook);
            return "redirect:/";
        }

    }

    private int randomNumber(){
        int number = (int) Math.round(Math.random()*9);
        return number;
    }

    private String randomBorrowedNumber(){
        String result = "";
        for (int i = 0;i<5;i++){
            result +=randomNumber();
        }
        return result;
    }
}
