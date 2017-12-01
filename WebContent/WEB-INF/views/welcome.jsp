<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html  >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WelcomePage</title>
</head>
<body>


Enter Your Details Here
	<form action="/UpdateData" >
	
	
	
		<br>First Name:<br> <input type="text" name="First Name"><br>
		<br> Last Name:<br> <input type="text" name="Last Name"><br>
		<br> Department:<br> <input type="text" name="Department"><br>
		<br> Phone Number:<br><input type="text" name="Phone Number"><br> 
		<br>Salary:<br> <input type="text" name="Salary"><br> 
		<br>Email ID:<br> <input type="text" name="Email ID"><br>
		<br> Password:<br> <input type="Password" name="Password"><br>
		
		<br> Gender:<br> <select name="Gender">
		
			<option value="Other" ${param.Gender == "Other" ? 'selected' : ''}>Select</option>
			<option value="Male" ${param.Gender == "Male" ? 'selected' : ''}>Male</option>
			<option value="Female" ${param.Gender == "Female"? 'selected' : ''}>Female</option>
			<option value="Gender" ${param.Gender == "Other"? 'selected' : ''}>Other</option>
			
		</select>
		<br> <br> <input type="submit" value="SignUP">
		
	</form>
	<form action="/signin">
		<br> <br> <input type="submit" value="SignIn">
	</form>
</body>
</html>