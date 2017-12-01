package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Authenticate;
import database.DbContent;


@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3020976664111596674L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{	

		String Email= request.getParameter("Email ID");
		String Password = request.getParameter("Password");
	
		DbContent dbc =new DbContent();
		Authenticate dba  = new Authenticate();
		request.getSession().setAttribute("list", dbc.content(Email));
		
		int count = dba.authenticate(Email, Password);
		
		if (count == 1) 
		{
			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		}
		else 
		{
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

}
