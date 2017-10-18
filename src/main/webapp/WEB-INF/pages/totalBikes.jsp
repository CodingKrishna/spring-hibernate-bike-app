<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="com.todo.bike.model.BikeEntity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/stylesheets/file1.css">
<style type="text/css">
td {
	font-family: cursive
}

</style>
</head>
<body class="bg3">
<%
	List<BikeEntity> totalBikes = (List<BikeEntity>) request.getAttribute("totalBikes");
	if(totalBikes.size() == 0) {
%>
		<table><tr><td> <h3> <font color="red"> No Bikes Available</h3> </font></td></tr></table>
<%
	} else {
		
%>
	<table align="center" bgcolor="pink" cellpadding="9" cellspacing="9">
	<tr><td align="center" colspan="10"><h3>Available Bikes</h3></td></tr>
	<tr bgcolor="lightblue"><td>Bike Id</td><td>Bike Name</td><td>Model</td><td>Price</td><td>Delivery Date</td><td>Book</td></tr>
<%
		for(int i=0; i<totalBikes.size(); i++) {
			BikeEntity bikeEntity = totalBikes.get(i);
%>
	<tr bgcolor="lightgreen">
		<td><%=bikeEntity.getId() %></td>
		<td><%=bikeEntity.getName() %></td>
		<td><%=bikeEntity.getModel() %></td>
		<td><%=bikeEntity.getPrice() %></td>
		<td><%=bikeEntity.getDate() %></td>
		<td><a href="bookBike.mmm?bikeId=<%=bikeEntity.getId()%>">Book</a></td>	
	</tr>
<%
		}
%>
	</table>
<%
	}
%>
</body>
</html>