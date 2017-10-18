<%@page import="com.todo.bike.dto.BookingHistoryDto"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.todo.bike.dto.BikeDto"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*, java.text.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./resources/stylesheets/file1.css">
<title>Insert title here</title>
<style type="text/css">
td {
	font-size: large;
	font-family: monospace;
}
</style>
</head>
<body class="bikeHomeImage">
<%
	BookingHistoryDto bookingHistoryDto= (BookingHistoryDto)request.getAttribute("bookingHistoryDto");
%>
<form:form commandName="bookingHistoryDto" action="bookingSuccess.mmm">
	<table align="center" bgcolor="lightpink" cellpadding="10" cellspacing="10">
		
		<tr><td>
			<input type="hidden" name="bikeId" value="<%=bookingHistoryDto.getBikeId()%>"/>
			<input type="hidden" name="bikeName" value="<%=bookingHistoryDto.getBikeName()%>"/>
			<input type="hidden" name="bikeModel" value="<%=bookingHistoryDto.getBikeModel()%>"/>
			<input type="hidden" name="price" value="<%=bookingHistoryDto.getPrice()%>"/>
			<input type="hidden" name="deliveryDate" value="<%=bookingHistoryDto.getDeliveryDate()%>"/>
			<input type="hidden" name="bookingDate" value="<%=bookingHistoryDto.getBookingDate()%>"/>
		</td></tr>
		
		<tr bgcolor="lightgreen"><td align="center" colspan="10"><font size="5">Booking Details</font></td></tr>
		
		<tr><td>Bike Id</td><td>:</td><td><%=bookingHistoryDto.getBikeId() %></td></tr> 
		<tr><td>Bike Name</td><td>:</td><td><%=bookingHistoryDto.getBikeName() %></td></tr>
		<tr><td>Bike Model</td><td>:</td><td><%=bookingHistoryDto.getBikeModel() %></td></tr>
		<tr><td>Price</td><td>:</td><td><%=bookingHistoryDto.getPrice() %></td></tr> 
		<tr><td>Delivery Date</td><td>:</td><td><%=bookingHistoryDto.getDeliveryDate() %></td></tr>
		
		<tr><td>Name</td><td>:</td><td><form:input type="text" path="buyerName"/></td>
		<tr><td>Phone Number</td><td>:</td><td><form:input type="text" path="phoneNumber"/></td></tr>
		<tr><td>Address</td><td>:</td><td><form:input type="textarea" path="address"/></td></tr>
		<tr><td>Booking Date</td><td>:</td><td><%=bookingHistoryDto.getBookingDate() %></td></tr>
		
		<tr><td colspan="10" align="center"><input type="submit" value="Book Confirm"></td></tr>
	</table>
	</form:form>
	<!--
		HttpSession sess= request.getSession();
		sess.setAttribute("bookingHistoryDto", bookingHistoryDto); 
	  -->
	  
</body>
</html>