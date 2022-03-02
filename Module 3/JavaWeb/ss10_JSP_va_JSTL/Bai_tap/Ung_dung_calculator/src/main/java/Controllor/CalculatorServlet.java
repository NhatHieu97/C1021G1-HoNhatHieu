package Controllor;

import Model.Calculetor;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          Double firstOperand = Double.parseDouble(request.getParameter("first"));
          Double secondOperand = Double.parseDouble(request.getParameter("second"));
          String operator = request.getParameter("operator");
          Double result = Calculetor.calculate(firstOperand,operator,secondOperand);
          request.setAttribute("result",result);
          request.getRequestDispatcher("result.jsp").forward(request,response);





    }
}
