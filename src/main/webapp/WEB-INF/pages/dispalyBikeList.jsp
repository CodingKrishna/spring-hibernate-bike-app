<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.todo.bike.model.BikeEntity"%>

	
	<%
		List<BikeEntity> bikesList = (List<BikeEntity>)request.getAttribute("bikesList");
		if(bikesList == null){
			%>	<div align="center"><font color="red" style="pitch-range: inherit;"><h3>No Bikes available in this date... Please select Different Date..</h3></font></div>	<%
		}else {%>
		
		<table bgcolor="lightblue" align="center" cellpadding="8" cellspacing="8">
		<tr bgcolor="lightgreen"><td>Bike Id</td><td>Bike Name</td><td>Model</td><td>Price</td><td>Delivery Date</td><td>Book</td></tr>
		
		<%		for(int i=0; i<bikesList.size(); i++) {
			BikeEntity bikeEntity = bikesList.get(i);
	%>
			<tr bgcolor="lightyellow">
				<td><%=bikeEntity.getId() %></td>
				<td><%=bikeEntity.getName() %></td>
				<td><%=bikeEntity.getModel() %></td>
				<td><%=bikeEntity.getPrice() %></td>
				<td><%=bikeEntity.getDate() %></td>
				<td><a href="bookBike.mmm?bikeId=<%=bikeEntity.getId()%>">Book</a></td>
			</tr>
	<%}
	}%>	
	</table>
