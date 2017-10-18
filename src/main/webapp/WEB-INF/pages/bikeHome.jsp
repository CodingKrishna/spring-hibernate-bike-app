<%@page import="org.codehaus.jackson.map.util.JSONPObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/stylesheets/file1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type = "text/javascript" 
         src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script>
	jQuery(document).ready(function($) {

		$("#search-form").submit(function(event) {

			// Disble the search button
			//enableSearchButton(false);

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			searchViaAjax();

		});

	});

	function searchViaAjax() {
		var searchDate = $("#searchDate").val();
		$.ajax({
			type : "GET",
			url : $("#search-form").attr("action"),
			data : 'searchDate='+searchDate,
			dataType: "html",
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}

	function enableSearchButton(flag) {
		$("#btn-search").prop("disabled", flag);
	}

	function display(data) {
		
		$('#ajaxBikeResponse').html(data);
	}
</script>

<style>
.button 
{
	color: lime;
}
</style>
</head>
<body class=bikeHomeImage>
	<table align="left"><tr><td> <button><a href="totalBikes.mmm">Available Bikes</a> </td></tr></table>
	<table align="right"><tr><td> <button><a href="bookingHistory.mmm">Booking History</a> </td></tr></table>
	<div align="center">
		<form  action="getBikesbyDate.mmm" id="search-form" method="get">
			<div align="center"> <font color="blue"> <h3>	Select Date for delivery availability </h3> </font> </div>
			<div align="center">	<input type="date"  id ="searchDate"/> <font color="green"> <button type="submit">Search</button> </font>    </div>
	</form>
	<div id="ajaxBikeResponse"> </div>
	</div>
</body>
</html>