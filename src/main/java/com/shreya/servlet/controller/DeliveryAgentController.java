package com.shreya.servlet.controller;
import  com.shreya.servlet.exception.DeliveryAgentException;
import  com.shreya.servlet.model.Customer;
import  com.shreya.servlet.model.DeliveryAgent;
import  com.shreya.servlet.service.DeliveryAgentService;
import jakarta.servlet.http.HttpServlet;

import java.util.Scanner;

public class DeliveryAgentController extends HttpServlet {
    private final DeliveryAgentService deliveryAgentService = new DeliveryAgentService();
    private Customer C = new Customer();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int option;
        do{
            System.out.println("\n---- DeliveryAgent ----");
            System.out.println("1. Add DeliveryAgent");
            System.out.println("2. View DeliveryAgent Details");
            System.out.println("0. Back to the Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(sc.nextLine());
            try {
                switch (option) {
                    case 1:
                        deliveryAgentService.createDeliveryAgent();
                        DeliveryAgent deliveryAgent = new DeliveryAgent();
                        deliveryAgentService.displayDeliveryAgent();
                        System.out.println("DeliveryAgent " + deliveryAgent );
                        break;
                    case 2:
                        deliveryAgentService.displayDeliveryAgent();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (DeliveryAgentException e) {
                System.out.println("Error: " + e.getClass());
            }
        } while (option != 0);
    }
}
