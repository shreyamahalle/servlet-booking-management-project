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
                <th>City</th>
                <th>Mobile No</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>  <!-- use lowercase .name -->
                    <td>${customer.city}</td>
                    <td>${customer.mobileNo}</td>
                    <td>${customer.age}</td>
                </tr>
            </c:forEach>
        </tbody>
        <br/>
            <a href="index.html">Back to Home</a>
    </table>
</body>
</html>
