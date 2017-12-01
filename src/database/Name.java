package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Name {
	public static String demourl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	public static String user = "root";
	public static String password = "";
	public String getName(String EmailID) {
		String name="";
		try {
			Connection demoCon=DriverManager.getConnection(demourl,user,password);
			PreparedStatement demoStmt=demoCon.prepareStatement("Select first_Name,last_Name from employees where email_id=?");
			demoStmt.setString(1, EmailID);
			ResultSet demoRs=demoStmt.executeQuery();
			while(demoRs.next()) {
				name=demoRs.getString("First_Name")+demoRs.getString("Lasr_Name");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
		
	}

}
