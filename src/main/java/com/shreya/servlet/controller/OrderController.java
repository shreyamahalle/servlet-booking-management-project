package com.shreya.servlet.controller;

import com.shreya.servlet.exception.CustomerException;
import com.shreya.servlet.model.Customer;
import com.shreya.servlet.model.Order;
import com.shreya.servlet.service.CustomerService;
import com.shreya.servlet.service.OrderService;
import jakarta.servlet.http.HttpServlet;

import java.sql.SQLException;
import java.util.Scanner;

public class OrderController extends HttpServlet {

    OrderService orderService = new OrderService();
    Order order = new Order();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int option;
        do {
            System.out.println("\n---- Order ----");
            System.out.println("1. Add Order");
            System.out.println("2. View Order Details");
            System.out.println("3. create Order on db");
            System.out.println("4. delete Order on db");
            System.out.println("5. Retrieve Order");
            System.out.println("6. Update Order");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        orderService.createOrder();
                        orderService.displayOrder();
                        orderService.displayOrder();
                        System.out.print("Order " + order);
                        break;
                    case 2:
                        orderService.displayOrder();
                        break;
                    case 3:
                        System.out.println("Performing create operation on Order");
                        OrderService.insertOrder(new Order(135, "pizza", "good", "gpay"));
                        break;
                    case 4:
                        System.out.println("delete Order");
                        OrderService.deleteOrder();
                        break;
                    case 5:
                        System.out.println("Retrieve Order");
                        orderService.retrieveOrders().forEach(order -> {
                            System.out.println("order ID: " + order.getId() + ", type: " + order.getType());
                        });
                        break;
                    case 6:
                        System.out.println("Update Order");
                        OrderService.updateOrder();

                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("All Good ");
            }
        } while (option != 0);
    }
}

