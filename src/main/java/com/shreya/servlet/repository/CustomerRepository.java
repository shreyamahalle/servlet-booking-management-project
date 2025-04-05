package com.shreya.servlet.repository;
import com.shreya.servlet.model.Customer;
import com.shreya.servlet.service.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public boolean insertCustomer(Customer customer) {
        String query = "INSERT INTO customer (id, name, city, mobileNo, age) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = new ConnectionService().getConnection();  // GET connection here
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getCity());
            preparedStatement.setInt(4, customer.getMobileNo());
            preparedStatement.setInt(5, customer.getAge());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting customer: " + e.getMessage(), e);
        }
    }

    public List<Customer> retrieveCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";

        try (Connection connection = new ConnectionService().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getInt("mobileNo"),
                        resultSet.getInt("age")
                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving customers: " + e.getMessage());
        }

        return customers;
    }

    public Customer retrieveCustomer(int id, String name) {
        String query = "SELECT * FROM customer WHERE id = ? AND name = ?";
        Customer customer = null;

        try (Connection connection = new ConnectionService().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("city"),
                        resultSet.getInt("mobileNo"),
                        resultSet.getInt("age")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving customer: " + e.getMessage());
        }

        return customer;
    }

    public boolean deleteCustomer(int id) {
        String query = "DELETE FROM customer WHERE id = ?";

        try (Connection connection = new ConnectionService().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting customer: " + e.getMessage(), e);
        }
    }

    public boolean updateCustomer(int id, String name) {
        String query = "UPDATE customer SET name = ? WHERE id = ?";

        try (Connection connection = new ConnectionService().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating customer: " + e.getMessage(), e);
        }
    }
}
