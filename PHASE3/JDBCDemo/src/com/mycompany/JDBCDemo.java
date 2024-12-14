package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	
	// Insert Demo
		public static void main(String[] args) {

			// Step1 : Load the driver.
			// Above step is not needed for our Java versions
			Connection connection = null;
			try {
				// Step 2: Create a Connection object.
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

				// Step 3: Create a Statement object.

				Statement stmt = connection.createStatement();

				// Step 4: Execute the SQL command.
				
				String sql = "INSERT INTO products (name, price, category) VALUES('Apple Watch  3', 1100.00, 'Electronics'), ('Apple Watch  4', 1100.00, 'Electronics')";

				int rowCount = stmt.executeUpdate(sql);
				
				System.out.println("Successfully added " + rowCount +  " rows");

			} catch (SQLException e) {
				System.err.println(e);
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}

		}

	// Query Demo
	public static void main0(String[] args) {

		// Step1 : Load the driver.
		// Above step is not needed for our Java versions
		Connection connection = null;
		try {
			// Step 2: Create a Connection object.
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			// Step 3: Create a Statement object.

			Statement stmt = connection.createStatement();

			// Step 4: Execute the SQL command.

			ResultSet rs = stmt.executeQuery("SELECT * FROM estore.products");

			// Iterate the rows
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String category = rs.getString("category");

				System.out.println("id=" + id + ", Name=" + name + ", Price=" + price + ", Category=" + category);
			}

		} catch (SQLException e) {
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
