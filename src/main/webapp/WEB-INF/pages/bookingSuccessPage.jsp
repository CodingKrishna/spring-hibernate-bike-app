<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<table bgcolor="lightgreen" align="center"  cellspacing="20">
	<tr bgcolor="yellow"><td colspan="10" align="center">Bike booked Successfully..!</td></tr>
	
	<tr><td>Bike Id</td><td>:</td><td>${bookingHistoryDto.bikeId }</td></tr>
	<tr><td>Bike Name</td><td>:</td><td>${bookingHistoryDto.bikeName }</td></tr>
	<tr><td>Bike Model</td><td>:</td><td>${bookingHistoryDto.bikeModel }</td></tr>
	<tr><td>Price</td><td>:</td><td>${bookingHistoryDto.price }</td></tr>
	<tr><td>Buyer Name</td><td>:</td><td>${bookingHistoryDto.buyerName }</td></tr>
	<tr><td>Phone Number</td><td>:</td><td>${bookingHistoryDto.phoneNumber }</td></tr>
	<tr><td>Address</td><td>:</td><td>${bookingHistoryDto.address }</td></tr>
	<tr><td>Booked Date</td><td>:</td><td>${bookingHistoryDto.bookingDate }</td></tr>
	<tr><td>Delivery Date</td><td>:</td><td>${bookingHistoryDto.deliveryDate }</td></tr>
	
</table>
<div><a href="getLoginPage.mmm">Goto Login</a></div>
</body>
</html>