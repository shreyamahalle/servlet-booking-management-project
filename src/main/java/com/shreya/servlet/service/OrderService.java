package com.shreya.servlet.service;
import  com.shreya.servlet.model.Order;
import  com.shreya.servlet.repository.OrderRepository;

import java.util.HashMap;
import java.util.Scanner;

public class OrderService implements OrderNumberService {

    OrderRepository orderRepository = new OrderRepository();
    HashMap<Integer,Order> orders = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    void printCustomer(Order order){
        System.out.println(order);
    }
    public Order createOrder(String name){
        Order order = new Order();
        orderRepository.createOrder(order);
        orderRepository.displayOrder(order);
        orderRepository.displayOrderToBeClosed(1);

        try {
            System.out.println("Please enter id");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter type");
            String type = sc.nextLine();

            System.out.println("Please enter note");
            String note = sc.nextLine();

            System.out.println("Please enter paymentMethod");
            String paymentMethod = sc.nextLine();

            order.setId(id);
            order.setPaymentMethod(paymentMethod);
            order.setNote(note);
            order.setType(type);
            orders.put(1, order);
        }catch (Exception e){
            System.out.println("Invalid input type correct data");
        }
        return order;
    }
    @Override
    public void createOrderNo() {
    }

    public void deleteOrder(int orderId){
        String removeOrder = String.valueOf(orderId);
        System.out.println("remove order " + removeOrder );
    }
    public void displayOrder(){
        try {
//            Set<Map.Entry<Integer, Order>> entrySet = orders.entrySet();
//            for (Map.Entry<Integer, Order> customerEntry : entrySet) {
//                System.out.println("Customer Info: " + orders);
//            }

            //java 8 features forEach loop..
            orders.forEach((Id,orders) -> System.out.println("orderId " + Id + " = order info " + orders));

        }catch (Exception e){
            System.out.println("Invalid input type correct data");
        }

    }
}
