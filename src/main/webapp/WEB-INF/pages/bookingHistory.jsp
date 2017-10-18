<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="com.todo.bike.model.BookingHistoryEntity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/stylesheets/file1.css">
<style type="text/css">
td {
	font-family: monospace;
	font-size: x-large;
}
</style>
</head>
<body  class="bg3">
<table align="center" bgcolor="lightpink" cellpadding="5" cellspacing="5">
	<tr><td align="center" colspan="10"><h3>Booking History</h3></td></tr>
	<tr bgcolor="lightblue"><td>SNO</td><td>Bike Id</td><td>Bike Name</td><td>Bike Model</td><td>Price</td><td>Buyer Name</td><td>Phone Number</td><td>Address</td><td>Booking Date</td><td>Delivery Date</td></tr>
<%
	List<BookingHistoryEntity> bookingHistoryList = (List<BookingHistoryEntity>) request.getAttribute("bookingHistoryList");
	for(int i=0; i<bookingHistoryList.size();i++) {
		BookingHistoryEntity bookingHistoryEntity = bookingHistoryList.get(i);
		if(bookingHistoryEntity.getBikeId()!=0) {
%>
		<tr bgcolor="lightgreen">
			<td><%=bookingHistoryEntity.getId() %></td>
			<td><%=bookingHistoryEntity.getBikeId() %></td>
			<td><%=bookingHistoryEntity.getBikeName() %></td>
			<td><%=bookingHistoryEntity.getBikeModel() %></td>
			<td><%=bookingHistoryEntity.getPrice() %></td>
			<td><%=bookingHistoryEntity.getBuyerName() %></td>
			<td><%=bookingHistoryEntity.getPhoneNumber() %></td>
			<td><%=bookingHistoryEntity.getAddress() %></td>
			<td><%=bookingHistoryEntity.getBookingDate() %></td>
			<td><%=bookingHistoryEntity.getDeliveryDate() %></td>
		</tr>
<%		}
	}
%>
</table>
</body>
</html>