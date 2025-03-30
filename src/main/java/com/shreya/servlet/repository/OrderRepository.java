package com.shreya.servlet.repository;
import  com.shreya.servlet.model.Order;
import java.util.HashSet;
import java.util.Set;

public class OrderRepository {
    Set<Order> orders = new HashSet<>();

    public void createOrder(Order order){
        orders.add(order);
    }

    public void displayOrder(Order order){
        orders.remove(order);
    }

    public void displayOrderToBeClosed(int id){
        Order orderToBeClosed = null;
        for (Order order : orders){
            if (order.getId() == id){
                orderToBeClosed = order;
            }
        }
        orders.remove(orderToBeClosed);
    }

}
