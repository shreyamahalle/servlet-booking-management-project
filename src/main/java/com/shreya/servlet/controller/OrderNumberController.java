package com.shreya.servlet.controller;
import com.shreya.servlet.exception.CustomerException;
import com.shreya.servlet.impl.OrderNumberImpl;
import com.shreya.servlet.model.Customer;
import com.shreya.servlet.model.Order;
import com.shreya.servlet.service.OrderNumberService;
import com.shreya.servlet.service.OrderService;
import jakarta.servlet.http.HttpServlet;

import java.util.Scanner;

public class OrderNumberController extends HttpServlet {

    OrderNumberService orderNumberService = new OrderNumberImpl();
    OrderService orderService = new OrderService();
    private static final Customer C = new Customer();
    Order order = new Order();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        int option;
        do {
            System.out.println("\n---- Order ----");
            System.out.println("1. View Order Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        orderService.createOrder();
                        orderService.displayOrder();
                        System.out.print("Order " + order);
                        break;
                    case 2:
                        orderService.displayOrder();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } finally {
                System.out.println("All Good ");
            }
        } while (option != 0);
    }
}

