package com.shreya.servlet.repository;
import  com.shreya.servlet.model.Customer;
import java.util.HashSet;
import java.util.Set;

public class CustomerRepository {
    Set<Customer> customers = new HashSet<>();
    public void createCustomer(Customer customer){
        customers.add(customer);
    }
    public  void displayCustomers(Customer customer){
        customers.remove(customer);
    }
    public void displayCustomerToBeClosed(int id){
        Customer customerToBeClosed = null;
        for (Customer customer : customers){
            if (customer.getId() == id){
                customerToBeClosed = customer;
            }
        }
        customers.remove(customerToBeClosed);
    }
}
