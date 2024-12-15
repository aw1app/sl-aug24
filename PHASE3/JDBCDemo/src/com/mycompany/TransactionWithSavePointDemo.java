package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Arrays;

public class TransactionWithSavePointDemo {

	public static void main(String[] args) {

		Connection connection = null;
		Savepoint savePoint1 = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");
			connection.setAutoCommit(false);

			String insertSQL = "INSERT INTO products (name, price, category) VALUES (?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(insertSQL);
			
			stmt.setString(1, "Apple Laptop 1");
			stmt.setDouble(2, 300000000000.07878787878d);
			stmt.setString(3, "Electronics");
			
			System.err.println("WARNINGS: "+ stmt.getWarnings());
			
			stmt.executeUpdate();
			
			
			//Create a SavePoint
			savePoint1 = connection.setSavepoint("Savepoint1" );
			
			stmt.setString(1, "Apple Laptop 2");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
			
			stmt.executeUpdate();
			
			
			stmt.setString(1, "Apple Laptop 3");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");
			
			stmt.executeUpdate();			

			
			connection.commit();
			
			
			
		} catch (SQLException e) {
			System.err.println("Something went wrong!");
			System.err.println(e.getMessage());
			System.err.println(e.getErrorCode());
			
			
			
			try {
				connection.rollback(savePoint1);
				//connection.rollback();
				System.err.println("Rollback happened!");
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			
		}finally {
			try {
				System.err.println("WARNINGS: "+ connection.getWarnings());
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
