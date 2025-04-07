package com.shreya.servlet.controller;

import com.shreya.servlet.exception.CustomerException;
import com.shreya.servlet.model.Customer;
import com.shreya.servlet.model.Restaurant;
import com.shreya.servlet.service.CustomerService;
import com.shreya.servlet.service.RestaurantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantController extends HttpServlet {

    private static final RestaurantService restaurantService = new RestaurantService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the doGet() method ---------------");
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList = restaurantService.retrieveRestaurants();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Restaurant details</h1>");
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>registerNo</th>");
        out.println("<th>name</th>");
        out.println("<th>city</th>");
        out.println("<th>area</th>");
        out.println("</tr>");

        restaurantList.parallelStream().forEach(restaurant -> {
            out.println("<tr>");
            out.println("<td>" + restaurant.getRegisterNo() + "</td>");
            out.println("<td>" + restaurant.getName() + "</td>");
            out.println("<td>" + restaurant.getCity() + "</td>");
            out.println("<td>" + restaurant.getArea() + "</td>");
        });
        out.println("</table>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("---------------inside the doPost() method---------------");
        String registerNo = request.getParameter("registerNo");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String area = request.getParameter("are");

        Restaurant restaurant = new Restaurant();
        restaurant.setRegisterNo(Integer.parseInt(registerNo));
        restaurant.setName(name);
        restaurant.setCity(city);
        restaurant.setArea(area);

        try {
            boolean isInserted = restaurantService.insertRestaurant(restaurant);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> restaurant object inserted to db</h1>");
            } else {
                out.println("<h1> restaurant object not inserted to db</h1>");
            }
            out.println("</body></html");

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--------------- inside the service() method ---------------");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("--------------- inside the destroy() method ---------------");
    }
}

