package controller;

import model.CodeCreating;
import model.person.*;
import service.employee.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private EmployEducationDegreeServiceImpl employEducationDegreeService = new EmployEducationDegreeServiceImpl();
    private EmployeeDivisionServiceImpl employeeDivisionService = new EmployeeDivisionServiceImpl();
    private EmployeePositionServiceImpl employeePositionService = new EmployeePositionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeEducationDegree> employeeEducationDegreeList = employEducationDegreeService.findAll();
        List<EmployeeDivision> employeeDivisionList = employeeDivisionService.findAll();
        List<EmployeePosition> employeePositions = employeePositionService.findAll();
        List<Employee> employeeList =employeeService.findAll();
        Employee employee = employeeList.get(employeeList.size()-1);
        int id = employee.getId() + 1;
        String employeeCode = CodeCreating.setCode("NV-", id);
        request.setAttribute("code",employeeCode);
        request.setAttribute("id",id);
        request.setAttribute("employeeEducationDegreeList", employeeEducationDegreeList);
        request.setAttribute("employeeDivisionList", employeeDivisionList);
        request.setAttribute("employeePositions", employeePositions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<EmployeeEducationDegree> employeeEducationDegreeList = employEducationDegreeService.findAll();
        List<EmployeeDivision> employeeDivisionList = employeeDivisionService.findAll();
        List<EmployeePosition> employeePositions = employeePositionService.findAll();
        request.setAttribute("employeeEducationDegreeList", employeeEducationDegreeList);
        request.setAttribute("employeeDivisionList", employeeDivisionList);
        request.setAttribute("employeePositions", employeePositions);
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameEmployee = request.getParameter("name-employee");
        String employeeCode = request.getParameter("code");
        String birthday = request.getParameter("birthday");
        String idcard = request.getParameter("idcard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = null;
        String employeeEducationDegreeList = "";
        String employeeDivisionList = "";
        String employeePositions = "";
        int idEmployeeEducationDegreeList = Integer.parseInt(request.getParameter("employeeEducationDegreeList"));
        System.out.println(idEmployeeEducationDegreeList);
        int idEmployeeDivisionList = Integer.parseInt(request.getParameter("employeeDivisionList"));
        System.out.println(idEmployeeDivisionList);
        int idEmployeePositions = Integer.parseInt(request.getParameter("employeePositions"));
        System.out.println(idEmployeePositions);
        int salary = Integer.parseInt(request.getParameter("salary"));
        Employee employee = new Employee(id,nameEmployee, birthday,idcard,phone,email,address,employeeCode,
                employeeEducationDegreeList,employeePositions,employeeDivisionList,username,idEmployeePositions,idEmployeeDivisionList,idEmployeeEducationDegreeList,salary);
        employeeService.update(employee);

        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameEmployee = request.getParameter("name-employee");
        String employeeCode = request.getParameter("code");
        String birthday = request.getParameter("birthday");
        String idcard = request.getParameter("idcard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = null;
        String employeeEducationDegreeList = "";
        String employeeDivisionList = "";
        String employeePositions = "";
        int idEmployeeEducationDegreeList = Integer.parseInt(request.getParameter("employeeEducationDegreeList"));
        System.out.println(idEmployeeEducationDegreeList);
        int idEmployeeDivisionList = Integer.parseInt(request.getParameter("employeeDivisionList"));
        System.out.println(idEmployeeDivisionList);
        int idEmployeePositions = Integer.parseInt(request.getParameter("employeePositions"));
        System.out.println(idEmployeePositions);
        int salary = Integer.parseInt(request.getParameter("salary"));

//        int id, String name, String birthday, String idCard, String phone, String email, String address, String code,
//                String educationDegree, String position, String division, String userName, int idPosition, int idDivision, int idEducationDegree, int salary
        Employee employee = new Employee(id,nameEmployee, birthday,idcard,phone,email,address,employeeCode,
                employeeEducationDegreeList,employeePositions,employeeDivisionList,username,idEmployeePositions,idEmployeeDivisionList,idEmployeeEducationDegreeList,salary);
        employeeService.create(employee);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
