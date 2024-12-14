package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) {

		// Step1 : Load the driver.
		// Above step is not needed for our Java versions
		Connection connection = null;
		try {
			// Step 2: Create a Connection object.
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			// Step 3: Create a Statement object.
			String sql = "INSERT INTO products (name, price, category) VALUES(?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);			


			stmt.setString(1, "Apple Phone 2");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");
			
			
			int rowCount = stmt.executeUpdate();	
			
			System.out.println("Successfully inserted " + rowCount + " rows");
			
			stmt.clearParameters();
			stmt.setString(1, "Apple Phone 3");
			stmt.setDouble(2, 3100.0d);
			stmt.setString(3, "Electronics");
			
			
			rowCount = stmt.executeUpdate();	
			
			System.out.println("Successfully inserted " + rowCount + " rows");
			
			
		}catch (SQLException e) {
			System.err.println(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
}
