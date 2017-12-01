package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.UpdateTable;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/UpdateData")
public class UpdateServlet extends HttpServlet 
{

	/**
	* 
	*/
	private static final long serialVersionUID = 1318799324281241807L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		String First_Name = request.getParameter("First Name");
		String Last_Name = request.getParameter("Last Name");
		String Department = request.getParameter("Department");
		String Phone_Number = request.getParameter("Phone Number");
		String Salary = request.getParameter("Salary");
		String Email_ID = request.getParameter("Email ID");
		String Password = request.getParameter("Password");
		String Gender = request.getParameter("Gender");
	
		UpdateTable update = new UpdateTable();

		boolean check = update.updateTable(First_Name, Last_Name, Department, Phone_Number, Salary, Email_ID, Password,
				Gender);
		if (check == true) 
		{
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		else 
		{
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}

	}

}
