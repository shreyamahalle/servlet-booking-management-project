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
    public void destroy() {
        System.out.println("CustomerController destroyed.");
    }
}
