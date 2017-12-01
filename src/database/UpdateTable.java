package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateTable 
{
	public static String demourl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	public static String user = "root";
	public static String password = "";
	String First_Name, Last_Name, Department, Phone_Number, Email_ID, Password, Gender;
	int Salary;

	public boolean updateTable(String First_Name, String Last_Name, String Department, String Phone_Number,

		String Salary, String Email_ID, String Password, String Gender) 
	{
		boolean result = false;
		int emailIDCount=0;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Department = Department;
		this.Phone_Number = Phone_Number;
		this.Salary = Integer.parseInt(Salary);
		
		this.Email_ID = Email_ID;
		this.Password = Password;
		this.Gender = Gender;

		try 
		{
			Connection demoCon = DriverManager.getConnection(demourl, user, password);
			PreparedStatement demoStmt = demoCon
					.prepareStatement("select count(email_id) as count from employees where email_id=?");
			demoStmt.setString(1, Email_ID);
			ResultSet demoRs= demoStmt.executeQuery();
			while(demoRs.next()) {
				emailIDCount=demoRs.getInt("count");
			}

			if (emailIDCount== 0) 
			{
				demoStmt = demoCon.prepareStatement("insert into employees "
						+ "(Email_ID,First_Name, Last_Name, Department, Phone_Number, Salary, Password, Gender) "
						+ "values(?,?,?,?,?,?,?,?)");
				demoStmt.setString(1, this.Email_ID);
				demoStmt.setString(2, this.First_Name);
				demoStmt.setString(3, this.Last_Name);
				demoStmt.setString(4, this.Department);
				demoStmt.setString(5, this.Phone_Number);
				demoStmt.setInt(6, this.Salary);
				demoStmt.setString(7, this.Password);
				demoStmt.setString(8, this.Gender);

				demoStmt.execute();
			
				result = true;
			}else {
				result=true;
			}

		}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;
	}

	
	
	}
