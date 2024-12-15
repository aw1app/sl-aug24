package com.mycompany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {

	// Database connection details
	private static final String URL = "jdbc:mysql://localhost:3306/estore";
	private static final String USER = "root";
	private static final String PASSWORD = "rootroot";

	public static void main(String[] args) {
		try {
			demonstrateCachedRowSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void demonstrateCachedRowSet() throws SQLException {
        RowSetFactory factory = RowSetProvider.newFactory();
        
        try (CachedRowSet rowSet = factory.createCachedRowSet()) {
            // Initial data load
            loadInitialData(rowSet);
            System.out.println("Initial product data:");
            printRowSet(rowSet);

            System.out.println("\nMaking offline changes...");
            
            // Update operation
            try {
                updateProductPrice(rowSet, "Laptop", 1299.99);
                System.out.println("Price update completed.");
            } catch (SQLException e) {
                System.err.println("Error updating price: " + e.getMessage());
            }

            // Insert operation
            try {
                insertNewProduct(rowSet);
                System.out.println("New product insertion completed.");
            } catch (SQLException e) {
                System.err.println("Error inserting new product: " + e.getMessage());
            }

            // Show changes before sync
            System.out.println("\nChanges before synchronization:");
            rowSet.beforeFirst();
            printRowSet(rowSet);

            // Synchronize with database
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                rowSet.acceptChanges(conn);
                System.out.println("\nChanges synchronized with database.");
            }

            // Reload and show final data
            loadInitialData(rowSet);
            System.out.println("\nFinal data after synchronization:");
            printRowSet(rowSet);
        }
    }

    private static void loadInitialData(CachedRowSet rowSet) throws SQLException {
        rowSet.setUrl(URL);
        rowSet.setUsername(USER);
        rowSet.setPassword(PASSWORD);
        rowSet.setCommand("SELECT * FROM products ORDER BY id");
        rowSet.execute();
    }

    private static void updateProductPrice(CachedRowSet rowSet, String productName, double newPrice) 
            throws SQLException {
        rowSet.beforeFirst();
        while (rowSet.next()) {
            if (rowSet.getString("name").equals(productName)) {
                rowSet.updateDouble("price", newPrice);
                rowSet.updateRow();
                break;
            }
        }
    }

    private static void insertNewProduct(CachedRowSet rowSet) throws SQLException {
        // Save current position
        int currentRow = rowSet.getRow();
        
        try {
            rowSet.moveToInsertRow();
            rowSet.updateString("name", "Keyboard");
            rowSet.updateDouble("price", 45.00);
            rowSet.updateString("category", "Electronics");
            rowSet.insertRow();
            
            // Move back to previous position
            if (currentRow > 0) {
                rowSet.absolute(currentRow);
            } else {
                rowSet.beforeFirst();
            }
        } catch (SQLException e) {
            // If insert fails, ensure we restore position
            if (currentRow > 0) {
                rowSet.absolute(currentRow);
            } else {
                rowSet.beforeFirst();
            }
            throw new SQLException("Failed to insert new product: " + e.getMessage());
        }
    }
	private static void printRowSet(CachedRowSet rowSet) throws SQLException {
        // Print column headers
        System.out.printf("%-4s  %-20s  %12s  %-15s%n", 
            "ID", "Name", "Price", "Category");
        System.out.println("-".repeat(55));
        
        // Print each row with proper formatting
        while (rowSet.next()) {
            try {
                System.out.printf("%-4d  %-20s  %,12.2f  %-15s%n",
                    rowSet.getInt("id"),
                    rowSet.getString("name"),
                    rowSet.getDouble("price"),
                    rowSet.getString("category")
                );
            } catch (SQLException e) {
                System.err.printf("Error reading row: %s%n", e.getMessage());
            }
        }
    }
}
