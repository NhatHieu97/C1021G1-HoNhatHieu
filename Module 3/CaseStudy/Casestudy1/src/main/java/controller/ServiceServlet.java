package controller;

import model.person.Customer;
import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;
import service.service.IRentType;
import service.service.IService;
import service.service.IServiceType;
import service.service.impl.RentTypeImpl;
import service.service.impl.ServiceImpl;
import service.service.impl.ServiceTypeImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/services")
public class ServiceServlet extends HttpServlet {
    private IServiceType serviceType = new ServiceTypeImpl();
    private IService services = new ServiceImpl();
    private IRentType rentType = new RentTypeImpl();
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
            default:
                showList(request, response);
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = services.findAll();
        request.setAttribute("serviceList",serviceList);
        try {
            request.getRequestDispatcher("service/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = services.findAll();
        Service service = serviceList.get(serviceList.size()-1);
        int id = service.getIdService() + 1;
        request.setAttribute("id",id);
        List<RentType> rentTypeList = rentType.findAll();
        System.out.println(rentTypeList.size());
        List<ServiceType> serviceTypeList = serviceType.findAll();
        request.setAttribute("rentTypeList",rentTypeList);
        request.setAttribute("serviceTypeList",serviceTypeList);
        try {
            request.getRequestDispatcher("service/create.jsp").forward(request,response);
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
                createCustomer(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String rentTypeName = request.getParameter("rentTypeName");
        double rentTypeCost = rentType.getCostById(id);
        String serviceTypeName = request.getParameter("serviceTypeName");

        Service service = new Service(id,name, serviceArea,serviceCost,serviceMaxPeople,standardRoom,
                descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeId,serviceTypeId,rentTypeName,rentTypeCost,serviceTypeName);
        services.create(service);
        try {
            response.sendRedirect("/services");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
