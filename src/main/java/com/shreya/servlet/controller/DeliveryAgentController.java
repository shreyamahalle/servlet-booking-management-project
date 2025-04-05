package com.shreya.servlet.controller;
import com.shreya.servlet.model.DeliveryAgent;
import com.shreya.servlet.service.CustomerService;
import com.shreya.servlet.service.DeliveryAgentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentController extends HttpServlet {
    private final DeliveryAgentService deliveryAgentService = new DeliveryAgentService();
    private final CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------- inside the doGet() method ---------------");
        List<DeliveryAgent> deliveryAgentList = new ArrayList<>();
        try {
            deliveryAgentList = deliveryAgentService.retrieveDeliveryAgents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Delivery Agent details</h1>");
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>id</th>");
        out.println("<th>name</th>");
        out.println("<th>city</th>");
        out.println("<th>mobileNo</th>");
        out.println("</tr>");

        deliveryAgentList.parallelStream().forEach(deliveryAgent -> {
            out.println("<tr>");
            out.println("<td>" + deliveryAgent.getId() + "</td>");
            out.println("<td>" + deliveryAgent.getName() + "</td>");
            out.println("<td>" + deliveryAgent.getCity() + "</td>");
            out.println("<td>" + deliveryAgent.getMobileNo() + "</td>");
        });
        out.println("</table>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("---------------inside the doPost() method---------------");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String mobileNo = request.getParameter("mobileNo");

        DeliveryAgent deliveryAgent = new DeliveryAgent();
        deliveryAgent.setId(Integer.parseInt(id));
        deliveryAgent.setName(name);
        deliveryAgent.setCity(city);
        deliveryAgent.setMobileNo(Integer.parseInt(mobileNo));

        try {
            boolean isInserted = deliveryAgentService.insertDeliveryAgent(deliveryAgent);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> delivery-agent object inserted to db</h1>");
            } else {
                out.println("<h1> delivery-agent object not inserted to db</h1>");
            }
            out.println("</body></html");

        } catch (IOException | SQLException e) {
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











//    private final DeliveryAgent deliveryAgent = new DeliveryAgent();
//    private final Customer customer = new Customer();
//    private final Scanner sc = new Scanner(System.in);
//
//    public void run() {
//        int option;
//        do {
//            System.out.println("---- DeliveryAgent ----");
//            System.out.println("1. Add DeliveryAgent");
//            System.out.println("2. View DeliveryAgent Details");
//            System.out.println("3. create DeliveryAgent in db");
//            System.out.println("4. delete DeliveryAgent in db");
//            System.out.println("5. Retrieve DeliveryAgent");
//            System.out.println("0. Back to the Main Menu");
//            System.out.print("Enter choice: ");
//
//            option = Integer.parseInt(sc.nextLine());
//            try {
//                switch (option) {
//                    case 1:
//                        deliveryAgentService.createDeliveryAgent();
//                        deliveryAgentService.displayDeliveryAgent();
//                        System.out.println("DeliveryAgent " + deliveryAgent);
//                        break;
//                    case 2:
//                        deliveryAgentService.displayDeliveryAgent();
//                        break;
//                    case 3:
//                        System.out.println("Performing create operation on deliveryAgent");
//                        DeliveryAgentService.insertDeliveryAgent();
//                        break;
//                    case 4:
//                        System.out.println("delete deliveryAgent");
//                        DeliveryAgentService.deleteDeliveryAgent();
//                        break;
//                    case 5:
//                        System.out.println("Retrieve DeliveryAgent");
//                        deliveryAgentService.retrieveDeliveryAgents().forEach(deliveryAgent -> {
//                            System.out.println("DeliveryAgent ID: " + deliveryAgent.getId() + ", name: " + deliveryAgent.getName());
//                        });
//                        break;
//                    case 0:
//                        System.out.println("Returning to Main Menu...");
//                        break;
//                    default:
//                        System.out.println("Invalid choice! Try again.");
//                }
//            } catch (DeliveryAgentException e) {
//                System.out.println("Error: " + e.getClass());
//            }
//        } while (option != 0);
//    }
//}
