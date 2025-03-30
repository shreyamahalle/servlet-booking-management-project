package com.shreya.servlet.service;

import com.shreya.servlet.exception.InvalideCustomerIDException;
import com.shreya.servlet.exception.InvalideCustomerNameException;
import com.shreya.servlet.model.Customer;

import java.sql.SQLException;

public interface CustomerServiceIInterface {
    void createCustomer() throws InvalideCustomerIDException, InvalideCustomerNameException, SQLException;

    void displayCustomers();

    Customer getCustomerById(int id);

}
