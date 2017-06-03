package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
		
		
		public static Connection getDBConnection() throws SQLException{
			String url = "jdbc:mysql://localhost/wedding?useSSL=false";
			String user = "root";
			String password = "delias";
			//Get the connection
			Connection myConn = DriverManager.getConnection(url,user,password);
			
			return myConn;
			
		}

}
