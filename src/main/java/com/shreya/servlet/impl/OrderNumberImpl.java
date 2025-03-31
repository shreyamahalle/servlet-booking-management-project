package com.shreya.servlet.impl;
import  com.shreya.servlet.service.OrderNumberService;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderNumberImpl implements OrderNumberService {

    @Override
    public void createOrderNo() {
        AtomicInteger orderNumberCounter = new AtomicInteger(100);
    }

//    @Override
//    public void displayOrder() {

    }

