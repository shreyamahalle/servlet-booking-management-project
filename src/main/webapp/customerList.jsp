<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Customer List</title></head>
<body>
    <h1>Customer List</h1>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>City</th><th>Mobile</th><th>Age</th></tr>
        <%
            List<com.shreya.servlet.model.Customer> customers = (List<com.shreya.servlet.CustomerController>) request.getAttribute("customers");
            for (com.shreya.servlet.model.Customer c : customers) {
        %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getName() %></td>
                <td><%= c.getCity() %></td>
                <td><%= c.getMobileNo() %></td>
                <td><%= c.getAge() %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
