package com.shreya.servlet.controller;
import com.shreya.servlet.exception.CustomerException;
import  com.shreya.servlet.model.Customer;
import  com.shreya.servlet.model.Restaurant;
import  com.shreya.servlet.service.RestaurantService;
import jakarta.servlet.http.HttpServlet;

import java.util.Scanner;

public class RestaurantController extends HttpServlet {


    private RestaurantService restaurantService = new RestaurantService();
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


