package vn.codegym.handleException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class HandleException {
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleNullPointerException(){
        return new ModelAndView("book/error");
    }
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(){
        return new ModelAndView("book/error");
    }
}
