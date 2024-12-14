package com.mycompany;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Step 2: Create a Connection object.
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			String sql = "{call GetProductsByCategory(?)}";

			CallableStatement stmt = connection.prepareCall(sql);

			stmt.setString(1, "Stationary");

			ResultSet rs = stmt.executeQuery();

			// Iterate the rows
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String category = rs.getString("category");

				System.out.println("ID=" + id + ", Name=" + name + ", Price=" + price + ", Category=" + category);
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
