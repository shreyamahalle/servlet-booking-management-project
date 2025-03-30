package com.shreya.servlet.service;
import  com.shreya.servlet.model.Restaurant;
import  com.shreya.servlet.repository.RestaurantRepository;
import java.util.*;

public class RestaurantService {
    private static final RestaurantRepository restaurantRepository = new RestaurantRepository();
    private static final HashMap<Integer,Restaurant> restaurants = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void createRestaurant(){

           Restaurant restaurant = new Restaurant();
            restaurantRepository.createRestaurant(restaurant);
            restaurantRepository.displayRestaurant(restaurant);
            restaurantRepository.displayRestaurantToBeClosed("name");
            try {

            System.out.println("Please enter registerNo");
            int registerNo = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter name");
            String name = sc.nextLine();

            System.out.println("Please enter city");
            String city = sc.nextLine();

            System.out.println("Please enter area");
            String area = sc.nextLine();

            restaurant.setRegisterNo(registerNo);
            restaurant.setName(name);
            restaurant.setCity(city);
            restaurant.setArea(area);
            restaurants.put(1,restaurant);
            }catch (Exception e){
                System.out.println("Invalid input type correct data");
            }
    }
    public static void displayRestaurant(){
        try {
//            Set<Map.Entry<Integer, Restaurant>> entrySet = restaurants.entrySet();
//            for (Map.Entry<Integer, Restaurant> customerEntry : entrySet) {
//                System.out.println("Customer Info: " + restaurants);
//            }
            //java 8 features forEach loop..
            restaurants.forEach((Id , restaurants) -> System.out.println("restaurant Id " + Id + " = restaurant Id " + restaurants));

        }catch (Exception e){
            System.out.println("Invalid input type correct data");
        }
    }
}