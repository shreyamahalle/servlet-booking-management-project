<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
    <h2>List of Customers</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>city</th>
                <th>mobileNo</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.Name}</td>
                    <td>${customer.city}</td>
                    <td>${customer.mobileNO}</td>
                    <td>${customer.age}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="http://localhost:8080/servlet-booking-management-project">Go to Home</a>
</body>
</html>