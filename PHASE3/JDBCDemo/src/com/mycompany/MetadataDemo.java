package com.mycompany;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetadataDemo {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Step 1: Connect to the Database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");
			
			DatabaseMetaData meta = conn.getMetaData();
			
			System.out.println(meta.getDatabaseProductName());
			System.out.println(meta.getDatabaseMajorVersion());
			System.out.println(meta.getDatabaseMinorVersion());
			
			ResultSet rs = meta.getCatalogs();
			
			while(rs.next()) {
				System.out.println(rs.getString(1));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
