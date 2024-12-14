package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class TransactionDemo {

	public static void main(String[] args) {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");
			connection.setAutoCommit(false);

			String insertSQL = "INSERT INTO products (name, price, category) VALUES (?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(insertSQL);
			
			stmt.setString(1, "Apple Laptop 1");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");
			
			stmt.addBatch();
		
			
			stmt.setString(1, "Apple Laptop 2");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
			
			stmt.addBatch();
			
			
			stmt.setString(1, "Apple Laptop 3");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");
			
			stmt.addBatch();
			
			int[] results = stmt.executeBatch();
			
			connection.commit();
			
			System.out.println(Arrays.toString(results));
			
		} catch (SQLException e) {
			System.err.println("Something went wrong!");
			System.err.println(e);
			
			try {
				connection.rollback();
				System.err.println("Rollback happened!");
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			
		}

	}

}
