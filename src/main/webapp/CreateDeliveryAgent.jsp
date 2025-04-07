<!-- JSP Directive -->

<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Booking Management System</h1>
<form action="/servlet-booking-management-project/DeliveryAgentController" method="POST">
    <label> id: </label>
	<input type = "textbox" id ="id" name="id"/>
	<br/>
	<label> Name: </label>
	<input type = "textbox" id ="name" name="name"/>
	<br/>
	<label>city: </label>
	<input type = "textbox" id ="city" name="city"/>
	<br/>
	<label>mobileNo : </label>
	<input type = "textbox" id ="mobileNo" name="mobileNo"/>
	<br/>
	<input type = "submit" value="Save Data"/>
	 <input type="reset" value="Clear">
	 <br>
     <div>
         <button onclick="location.href='index.html'">Back to Home</button>
     </div>
</form>
</body>
</html>