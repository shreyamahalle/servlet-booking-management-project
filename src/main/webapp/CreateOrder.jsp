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
<form action="/servlet-booking-management-project/orderController" method="POST">
    <label> id: </label>
	<input type = "textbox" id ="id" name="id"/>
	<br/>
	<label> type: </label>
	<input type = "textbox" id ="type" name="type"/>
	<br/>
	<label> note: </label>
	<input type = "textbox" id ="note" name="note"/>
	<br/>
	<label> paymentMethod: </label>
	<input type = "textbox" id ="paymentMethod" name="paymentMethod"/>
	<input type = "submit" value="Save Data"/>
	 <input type="reset" value="Clear">
</form>
</body>
</html>