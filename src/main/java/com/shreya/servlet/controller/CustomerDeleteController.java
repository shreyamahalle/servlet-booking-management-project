package com.shreya.servlet.controller;
import com.shreya.servlet.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CustomerDeleteController extends HttpServlet {

    private final CustomerService customerService = new CustomerService();

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("------ inside doPost() of DeleteController ------");
//
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        boolean isDeleted = false;
//        try {
//            isDeleted = customerService.deleteCustomer(id);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//
//        if (isDeleted) {
//            out.println("<h2>Customer deleted successfully!</h2>");
//        } else {
//            out.println("<h2>Customer not found / could not be deleted.</h2>");
//        }
//
//        out.println("</body></html>");
//    }

    // CustomerDeleteController.java
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
