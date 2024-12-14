package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class BatchDemo {

	public static void main(String[] args) {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			String insertSQL = "INSERT INTO products (name, price, category) VALUES (?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(insertSQL);
			
			stmt.setString(1, "Apple TV 1");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");
			
			stmt.addBatch();

			stmt.setString(1, "Apple TV 2");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");
			
			stmt.addBatch();
			
			stmt.setString(1, "Apple TV 3");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");
			
			stmt.addBatch();
			
			int[] results = stmt.executeBatch();
			
			System.out.println(Arrays.toString(results));
			
		} catch (SQLException e) {

		}

	}

}
