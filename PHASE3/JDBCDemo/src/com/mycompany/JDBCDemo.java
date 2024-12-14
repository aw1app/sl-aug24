package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {

		// Step1 : Load the driver.
		// Above step is not needed for our Java versions

		try {
			// Step 2: Create a Connection object.
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root",
					"rootroot");

			// Step 3: Create a Statement object.

			Statement stmt = connection.createStatement();

			// Step 4: Execute the SQL command.

			ResultSet rs = stmt.executeQuery("SELECT * FROM estore.products");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String category = rs.getString("category");

				System.out.println("id=" + id + ", Name=" + name + ", Price=" + price + ", Category=" + category);
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
