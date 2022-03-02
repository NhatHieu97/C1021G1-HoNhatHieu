package com.codegym.service.iml;

import org.springframework.stereotype.Service;
import com.codegym.service.ICaculatorService;
@Service
public class CaculatorServiceImpl implements ICaculatorService {
    @Override
    public double caculator(double num1, double num2, String caculator) {
        double result = 0;
        switch (caculator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;

        }
        return result;
    }
}
