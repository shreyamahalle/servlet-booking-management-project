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
            // Retrieve the customer list
            List<Customer> customerList = customerService.retrieveCustomers();
            req.setAttribute("customerList", customerList);  // Set the list to the request scope
            req.getRequestDispatcher("/DisplayCustomer.jsp").forward(req, res);  // Forward the request to JSP
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

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");  // This must not be null

        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Customer ID is required.");
            return;
        }

        int id = Integer.parseInt(idStr);  // This line throws error if idStr is null

        boolean deleted = false; // Assuming service accepts id
        try {
            deleted = customerService.deleteCustomer(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (deleted) {
            out.println("<h1>Customer deleted successfully</h1>");
        } else {
            out.println("<h1>Customer not found</h1>");
        }
        out.println("</body></html>");
    }

    protected void Update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = String.valueOf(Integer.parseInt(req.getParameter("name")));

        boolean customer = customerService.updateCustomer(id, "name");
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/update-customer.html").forward(req, res);
    }

    public void destroy() {
        System.out.println("CustomerController destroyed.");
    }
}
