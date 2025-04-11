package com.shreya.servlet.controller;

import com.shreya.servlet.model.Customer;
import com.shreya.servlet.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
    private final CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            List<Customer> customerList = customerService.retrieveCustomers();
            req.setAttribute("customerList", customerList);
            req.getRequestDispatcher("/DisplayCustomer.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Something went wrong: " + e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, res);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        int mobileNo = Integer.parseInt(req.getParameter("mobileNo"));
        int age = Integer.parseInt(req.getParameter("age"));

        Customer customer = new Customer(id, name, city, mobileNo, age);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            if (customerService.insertCustomer(customer)) {
                out.println("<h2>Customer inserted successfully!</h2>");
            } else {
                out.println("<h2>Failed to insert customer.</h2>");
            }
        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}


//package com.shreya.servlet.controller;
//
//import com.shreya.servlet.model.Customer;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import com.shreya.servlet.service.CustomerService;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomerController extends HttpServlet {
//
//    private final CustomerService customerService = new CustomerService();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("--------------- inside the doGet() method ---------------");
//        List<Customer> customerList = new ArrayList<>();
//        try {
//            customerList = customerService.retrieveCustomers();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Customer details</h1>");
//        out.println("<table border=1>");
//        out.println("<tr>");
//        out.println("<th>id</th>");
//        out.println("<th>name</th>");
//        out.println("<th>city</th>");
//        out.println("<th>mobileNo</th>");
//        out.println("<th>age</th>");
//        out.println("</tr>");
//
//        customerList.parallelStream().forEach(customer -> {
//            out.println("<tr>");
//            out.println("<td>" + customer.getId() + "</td>");
//            out.println("<td>" + customer.getName() + "</td>");
//            out.println("<td>" + customer.getCity() + "</td>");
//            out.println("<td>" + customer.getAge() + "</td>");
//            out.println("<td>" + customer.getMobileNo() + "</td>");
//        });
//        out.println("</table>");
//        out.println("</body></html>");
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("---------------inside the doPost() method---------------");
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        String city = request.getParameter("city");
//        String mobileNo = request.getParameter("mobileNo");
//        String age = request.getParameter("age");
//
//        Customer customer = new Customer();
//        customer.setId(Integer.parseInt(id));
//        customer.setName(name);
//        customer.setCity(city);
//        customer.setMobileNo(Integer.parseInt(mobileNo));
//        customer.setAge(Integer.parseInt(age));
//
//        try {
//            boolean isInserted = customerService.insertCustomer(customer);
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<html><body>");
//            if (isInserted) {
//                out.println("<h1> customer object inserted to db</h1>");
//            } else {
//                out.println("<h1> customer object not inserted to db</h1>");
//            }
//            out.println("</body></html");
//
//        } catch (SQLException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        System.out.println("--------------- inside the service() method ---------------");
//        if (request.getMethod().equals("POST")) {
//            this.doPost(request, response);
//        } else {
//            this.doGet(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("--------------- inside the destroy() method ---------------");
//    }
//}
//}