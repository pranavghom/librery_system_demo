package librery_system_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnction {
	
	public static Connection  dbcon()
	{
		Connection Con = null;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	    } catch (ClassNotFoundException e)
	       {
		// TODO Auto-generated catch block
		e.printStackTrace();
	       }
	String url = "jdbc:mysql://localhost:3306/librariy manegemnet system";
		try {
		 Con = DriverManager.getConnection(url,"root","root");
		    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		
		
		}
		return Con;
	}
}

