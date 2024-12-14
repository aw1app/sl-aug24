package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {

	public static void main(String[] args) {
		
		//Step1 : Load the driver. 
		//Above step is not needed for our Java versions
		
		
		//Step 2: Create a Connection object.
		try {
		Connection connection =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/estore",
				"root", "rootroot");
		}catch (SQLException e) {
			
		}
		

	}

}
