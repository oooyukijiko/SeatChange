<%@page import="model.Seat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

Seat seat = (Seat)application.getAttribute("seat"); 


%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>seatChangeResult</title>
		<link rel="stylesheet" href="Seat.css">
	</head>
	
	<body>
		<table>
		<%for(int i = 0; i < seat.getSeat().length; i++){ %>
			<tr>
		<%	for(int j = 0; j < seat.getSeat()[0].length; j++){ %>
				<th>
				<% if(!(seat.getSeat()[i][j].chars().allMatch(Character::isDigit))){ %>
					<%= seat.getSeat()[i][j] %>
				<% }%>
				</th>
		<%  } %>
			</tr>
		<%} %>
		</table>
	</body>
	
</html>