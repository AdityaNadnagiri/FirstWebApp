package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbContent {
	public static String demourl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	public static String user = "root";
	public static String password = "";
	String First_Name, Last_Name, Department, Phone_Number, Email_ID, Password, Gender;
	int Salary;
	public ArrayList<String[]> content(String Email) {
		
		
		this.Email_ID = Email;
		ArrayList<String[]> al=new ArrayList<>();

		try 
		{
			
			Connection demoCon = DriverManager.getConnection(demourl, user, password);
			PreparedStatement demoStmt = demoCon.prepareStatement(
					"select * from employees where email_id!=?");
			demoStmt.setString(1, Email_ID);
			
			ResultSet demoRs = demoStmt.executeQuery();
			
			while (demoRs.next()) 
			{
				String[] eid=new String[7];
				
					eid[0]=demoRs.getString("Email_ID");
					eid[1]=demoRs.getString("Last_Name");
					eid[2]=demoRs.getString("First_Name");
					eid[3]=demoRs.getString("Department");
					eid[4]=demoRs.getString("Phone_Number");
					eid[5]=demoRs.getString("Salary");
					eid[6]=demoRs.getString("Gender");
					al.add(eid);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return al;
		
	}

}
