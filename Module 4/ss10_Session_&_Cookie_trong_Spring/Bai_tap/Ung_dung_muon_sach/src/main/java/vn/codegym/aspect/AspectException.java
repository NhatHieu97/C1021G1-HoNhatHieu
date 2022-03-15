package vn.codegym.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Aspect
public class AspectException {
    private int visitedNumber =0;
    @Pointcut("execution(* vn.codegym.controller.BookController.payBook(..))")
    public void affterPayBookController(){
    }
    @AfterThrowing("affterPayBookController()")
    public void throwaffterPayBookController(){
        System.out.println("mã đã nhập không đúng");
    }
    @Pointcut("execution(* vn.codegym.controller.BookController.showFormBorrow(..))")
    public void afterBorrowBookController(){
    }

    @AfterThrowing("afterBorrowBookController()")
    public void throwAfterBorrowBookController(){
        System.out.println("Sách đã hết");
    }

    @Pointcut("execution(* vn.codegym.controller.BookController.*(..))")
    public void afterVisittedController(){
    }

    @After("afterVisittedController()")
    public void throwAfterVisittedController(){
        visitedNumber++;
        System.out.println("Số lượt truy cập hiện tại là "+ visitedNumber);
    }
}
