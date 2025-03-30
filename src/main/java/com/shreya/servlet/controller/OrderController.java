package com.shreya.servlet.controller;
import  com.shreya.servlet.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class OrderController extends HttpServlet {


    OrderService orderService = new OrderService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("----------inside the doGet() method------------");
        String name = request.getParameter("name");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + orderService.createOrder(name) + "</h1>");

        writer.println("</body></html>");
    }

    public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------inside the service() method---------------");
        this.doGet(request,response);
    }

    public void destroy(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------inside the destroy() method---------------");

    }












































//    private Customer C = new Customer();
//    Order order = new Order();
//    private Scanner sc = new Scanner(System.in);
//
//    public void run() {
//        int option;
//        do{
//            System.out.println("\n---- Order ----");
//            System.out.println("1. Add Order");
//            System.out.println("2. View Order Details");
//            System.out.println("0. Back to Main Menu");
//            System.out.print("Enter choice: ");
//
//            option = Integer.parseInt(sc.nextLine());
//            try {
//                switch (option) {
//                    case 1:
//                        orderService.createOrder(name);
//                        orderService.displayOrder();
//                        orderService.deleteOrder(1);
//                        orderService.displayOrder();
//                        System.out.print("Order " + order);
//                        break;
//                    case 2:
//                        orderService.displayOrder();
//                        break;
//                    case 0:
//                        System.out.println("Returning to Main Menu...");
//                        break;
//                    default:
//                        System.out.println("Invalid choice! Try again.");
//                }
//            } catch (CustomerException e) {
//                System.out.println("Error: " + e.getClass());
//            } finally {
//                System.out.println("All Good ");
//            }
//        } while (option != 0);
//    }
}

