<%@page import="database.DbContent"%>
<%@page import="servlets.HomeServlet"%>
<%@page import="database.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>

	<P>HI, Login Successful..</P>

	<table>

		<tr>
			<td><b>Email_ID</b></td>
			<td><b>First_Name</b></td>
			<td><b>Last_Name</b></td>
			<td><b>Department</b></td>
			<td><b>Phone_Number</b></td>
			<td><b>Salary</b></td>
			<td><b>Gender</b></td>
		</tr>

		<c:forEach items="${list}" var="itemArray">
			<tr>
				<c:forEach items="${itemArray}" var="item">
					<td><b><c:out value="${item}" /></b></td>
				</c:forEach>
			</tr>
		</c:forEach>

	</table>
	<form action="/home">
		<br> <input type="submit" value="LogOut">
	</form>
</body>
</html>