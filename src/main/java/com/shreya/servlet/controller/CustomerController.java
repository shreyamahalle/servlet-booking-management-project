package com.shreya.servlet.controller;
import  com.shreya.servlet.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CustomerController extends HttpServlet {

    CustomerService customerService = new CustomerService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("----------inside the doGet() method------------");
        String name = request.getParameter("name");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + customerService.greet(name) + "</h1>");

        writer.println("</body></html>");
    }

    public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------inside the service() method---------------");
        this.doGet(request,response);
    }

    public void destroy(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------inside the destroy() method---------------");

    }







//    private CustomerService customerService = new CustomerService();
//    Customer customer = new Customer();
//    private Scanner sc = new Scanner(System.in);
//
//    public void run() {
//        int option ;
//        do{
//            System.out.println("\n---- Customer ----");
//            System.out.println("1. Add Customer");
//            System.out.println("2. View Customer Details");
//            System.out.println("0. Back to Main Menu");
//            System.out.print("Enter choice: ");
//
//            option = Integer.parseInt(sc.nextLine());
//            try {
//                switch (option) {
//                    case 1:
//                        customerService.createCustomer();
//                        customerService.displayCustomers();
//                        customerService.displayCustomerInfo();
//                        System.out.println("Customer created : " + customer);
//                        break;
//                    case 2:
//                        customerService.displayCustomers();
//                        break;
//                    case 0:
//                        System.out.println("Returning to Main Menu...");
//                        break;
//                    default:
//                        System.out.println("Invalid choice! Try again.");
//                }
//            } catch (CustomerException e) {
//                System.out.println("Error: " + e.getClass());
//            }
//        } while (option != 0);
  //  }
}