package com.shreya.servlet.repository;
import  com.shreya.servlet.model.Restaurant;
import java.util.HashSet;
import java.util.Set;

public class RestaurantRepository {
    Set<Restaurant> restaurants = new HashSet<>();

    public void createRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public void displayRestaurant(Restaurant restaurant){
        restaurants.remove(restaurant);
    }

    public void displayRestaurantToBeClosed(String name){
        Restaurant restaurantToBeClosed = null;
        for (Restaurant restaurant : restaurants){
            if (restaurant.getName() == name){
                restaurantToBeClosed = restaurant;
            }
        }
        restaurants.remove(restaurantToBeClosed);
    }


}
