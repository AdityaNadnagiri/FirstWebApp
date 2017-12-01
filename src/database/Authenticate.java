package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticate {
	public static String demourl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	public static String user = "root";
	public static String password = "";
	String First_Name, Last_Name, Department, Phone_Number, Email_ID, Password, Gender;
	int Salary;

	public int authenticate(String Email_ID, String Password)
	 
	{
		// String fName="";
		// String lName="";
		int count = 0;
		this.Email_ID = Email_ID;
		this.Password = Password;

		try 
		{
			
			Connection demoCon = DriverManager.getConnection(demourl, user, password);
			PreparedStatement demoStmt = demoCon.prepareStatement(
					"select First_Name,Last_Name,count(email_id)as count from employees where email_id=? and password=?");
			demoStmt.setString(1, Email_ID);
			demoStmt.setString(2, Password);
			
			ResultSet demoRs = demoStmt.executeQuery();
			
			while (demoRs.next()) 
			{
				count = demoRs.getInt("count");
				// fName=demoRs.getString("First_Name");
				// lName=demoRs.getString("Last_Name");

			}

		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}


}
