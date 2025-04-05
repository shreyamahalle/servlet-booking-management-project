package com.shreya.servlet.controller;
import com.shreya.servlet.exception.CustomerException;
import com.shreya.servlet.model.Customer;
import com.shreya.servlet.model.Order;
import com.shreya.servlet.service.CustomerService;
import com.shreya.servlet.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController extends HttpServlet {

    private final OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the doGet() method ---------------");
        List<Order> orderList = new ArrayList<>();

        try {
            orderList = orderService.retrieveOrders();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Order details</h1>");
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>id</th>");
        out.println("<th>type</th>");
        out.println("<th>note</th>");
        out.println("<th>paymentMethod</th>");
        out.println("</tr>");

        orderList.parallelStream().forEach(order -> {
            out.println("<tr>");
            out.println("<td>" + order.getId() + "</td>");
            out.println("<td>" + order.getType() + "</td>");
            out.println("<td>" + order.getNote() + "</td>");
            out.println("<td>" + order.getPaymentMethod() + "</td>");
        });
        out.println("</table>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("---------------inside the doPost() method---------------");
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String note = request.getParameter("note");
        String PaymentMethod = request.getParameter("PaymentMethod");

        Order order = new Order();
        order.setId(Integer.parseInt(id));
        order.setNote(note);
        order.setType(type);
        order.setPaymentMethod(PaymentMethod);

        try {
            boolean isInserted = orderService.insertOrder(order);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> order object inserted to db</h1>");
            } else {
                out.println("<h1> order object not inserted to db</h1>");
            }
            out.println("</body></html");

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--------------- inside the service() method ---------------");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("--------------- inside the destroy() method ---------------");
    }
}

