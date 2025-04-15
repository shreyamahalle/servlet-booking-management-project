package com.shreya.servlet.service;

import com.shreya.servlet.model.Customer;
import com.shreya.servlet.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;


public class CustomerService {

    private static final CustomerRepository customerRepository = new CustomerRepository();

    public boolean insertCustomer(Customer customer) throws SQLException {
        return customerRepository.insertCustomer(customer);
    }

    public boolean updateCustomer(int id, String name) throws SQLException {
        return customerRepository.updateCustomer(id, name);
    }

    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    public Customer retrieveCustomer(int id, String name) throws SQLException {
        return customerRepository.retrieveCustomer(id, name);
    }

    public List<Customer> retrieveCustomers() throws SQLException {
        return customerRepository.retrieveCustomers();

    }
}
