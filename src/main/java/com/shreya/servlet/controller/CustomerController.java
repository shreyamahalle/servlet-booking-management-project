package com.shreya.servlet.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.shreya.servlet.service.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerController extends HttpServlet {

    private final CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--------------- inside the doGet() method ---------------");

        String name = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + customerService.greet(name) + "</h1>");
        writer.println("</body></html>");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------------- inside the service() method ---------------");
        super.service(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("--------------- inside the destroy() method ---------------");
    }
}









//        List<Customer> customerList = new ArrayList<>();
//        try {
//            customerList = customerService.retrieveCustomers();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<html><body>");
//            out.println("<h1>Student Details</h1>");
//            out.println("<table border=1>");
//            out.println("<tr>");
//            out.println("<th>id</th>");
//            out.println("<th>name</th>");
//            out.println("<th>age</th>");
//            out.println("<th>city</th>");
//            out.println("<th>mobileNo</th>");
//            out.println("</tr>");
//            customerList.parallelStream().forEach(customer -> {
//                out.println("<tr>");
//                out.println("<td>" + customer.getId() + "</td>");
//                out.println("<td>" + customer.getName() + "</td>");
//                out.println("<td>" + customer.getCity() + "</td>");
//                out.println("<td>" + customer.getAge() + "</td>");
//                out.println("<td>" + customer.getMobileNo() + "</td>");
//                out.println("</tr>");
//            });
//            out.println("</table>");
//            out.println("</body></html>");
//        }
//    }


//    CustomerRepository customerRepository = new CustomerRepository();
//    Customer customer = new Customer();
//    private final Scanner sc = new Scanner(System.in);
//
//    public void run() {
//        int option;
//        do {
//            System.out.println("\n---- Customer ----");
//            System.out.println("1. Add Customer");
//            System.out.println("2. View Customer Details");
//            System.out.println("3. create Customer on db");
//            System.out.println("4. delete Customer on db");
//            System.out.println("5. Retrieve Customer");
//            System.out.println("6. Update Customer");
//            System.out.println("0. Back to Main Menu");
//            System.out.print("Enter choice: ");
//
//            option = Integer.parseInt(sc.nextLine());
//            try {
//                switch (option) {
//                    case 1:
//                        customerService.createCustomer();
//                        customerService.displayCustomers();
//                        customerService.displayCustomerInfo();
//                        customerRepository.createCustomer(customer);
//                        customerRepository.displayCustomers(customer);
//                        System.out.println("Customer created : " + customer);
//                        break;
//                    case 2:
//                        customerService.displayCustomers();
//                        break;
//                    case 3:
//                        System.out.println("Performing create operation on Customer");
//                        CustomerService.insertCustomer(new Customer(101, "ABC", "pune", 908547358, 22));
//                        break;
//                    case 4:
//                        System.out.println("delete Customer");
//                        CustomerService.deleteCustomer();
//                        break;
//                    case 5:
//                        System.out.println("Retrieve Customer");
//                        customerService.retrieveCustomers().forEach(customer -> {
//                            System.out.println("customer ID: " + customer.getId() + ", name: " + customer.getName());
//                        });
//                        break;
//                    case 6:
//                        System.out.println("Update Customer");
//                        CustomerService.updateCustomer();
//                        break;
//
//                    case 0:
//                        System.out.println("Returning to Main Menu...");
//                        break;
//                    default:
//                        System.out.println("Invalid choice! Try again.");
//                }
//            } catch (CustomerException e) {
//                System.out.println("Error: " + e.getClass());
//            } catch (CustomerNotfound | SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } while (option != 0);
//    }
//}