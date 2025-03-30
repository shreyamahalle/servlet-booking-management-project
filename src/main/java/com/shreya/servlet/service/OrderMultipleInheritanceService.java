package com.shreya.servlet.service;

import com.shreya.servlet.model.Order;

import java.util.Scanner;

public class OrderMultipleInheritanceService extends Order {
    Scanner sc = new Scanner(System.in);

    public void displayOrder() {

        System.out.println("Order are not accepted ");
    }
}