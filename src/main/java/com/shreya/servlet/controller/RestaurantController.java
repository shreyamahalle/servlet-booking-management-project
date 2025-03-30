package com.shreya.servlet.controller;
import com.shreya.servlet.exception.CustomerException;
import  com.shreya.servlet.model.Customer;
import  com.shreya.servlet.model.Restaurant;
import  com.shreya.servlet.service.RestaurantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RestaurantController extends HttpServlet {


    private static final RestaurantService restaurantService = new RestaurantService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("----------inside the doGet() method------------");
        String name = request.getParameter("name");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + restaurantService+ "</h1>");

        writer.println("</body></html>");
    }

    public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------inside the service() method---------------");
        this.doGet(request,response);
    }

    public void destroy(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------inside the destroy() method---------------");

    }




















































    private Customer C = new Customer();
    Restaurant restaurant = new Restaurant();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int option;
        do{
            System.out.println("\n---- Order ----");
            System.out.println("1. Add Order");
            System.out.println("2. View Order Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        RestaurantService.createRestaurant();
                        RestaurantService.displayRestaurant();
                        System.out.print("restaurant " + restaurant);
                        break;
                    case 2:
                        RestaurantService.displayRestaurant();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            }
        } while (option != 0);
    }
}


