package com.mycompany.rowset;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CacheRowSetDemo {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/estore";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";

    public static void main(String[] args) {
        try {
            // First, let's create a sample table and insert some data
            createSampleData();

            // Demonstrate CacheRowSet operations
            demonstrateCacheRowSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createSampleData() throws SQLException {
        try (Connection conn = getConnection()) {
            var statement = conn.createStatement();

            // Drop table if exists and create new one
            statement.execute("DROP TABLE IF EXISTS employees");
            statement.execute("""
                CREATE TABLE employees (
                    id INT PRIMARY KEY,
                    name VARCHAR(100),
                    department VARCHAR(50),
                    salary DECIMAL(10,2)
                )
            """);

            // Insert sample data
            statement.execute("""
                INSERT INTO employees (id, name, department, salary) VALUES
                (1, 'John Doe', 'IT', 75000.00),
                (2, 'Jane Smith', 'HR', 65000.00),
                (3, 'Bob Wilson', 'IT', 80000.00)
            """);
        }
    }

    private static void demonstrateCacheRowSet() throws SQLException {
        // Create a RowSetFactory
        RowSetFactory factory = RowSetProvider.newFactory();
        
        // Create CachedRowSet instance
        try (CachedRowSet crs = factory.createCachedRowSet()) {
            // Configure the CachedRowSet
            crs.setUrl(URL);
            crs.setUsername(USER);
            crs.setPassword(PASSWORD);
            
            // Execute a query
            crs.setCommand("SELECT * FROM employees");
            crs.execute();

            System.out.println("Initial data:");
            printRowSet(crs);

            // Demonstrate offline operations
            // 1. Insert a new row
            crs.moveToInsertRow();
            crs.updateInt("id", 4);
            crs.updateString("name", "Alice Brown");
            crs.updateString("department", "Finance");
            crs.updateDouble("salary", 70000.00);
            crs.insertRow();
            crs.moveToCurrentRow();

            // 2. Update an existing row
            crs.beforeFirst();
            while (crs.next()) {
                if (crs.getInt("id") == 2) {
                    crs.updateString("department", "Marketing");
                    crs.updateRow();
                    break;
                }
            }

            // 3. Delete a row
            crs.beforeFirst();
            while (crs.next()) {
                if (crs.getInt("id") == 3) {
                    crs.deleteRow();
                    break;
                }
            }

            System.out.println("\nAfter modifications (before sync):");
            crs.beforeFirst();
            printRowSet(crs);

            // Get connection with proper transaction handling
            Connection conn = getConnection();
            try {
                // Disable auto-commit for transaction handling
                conn.setAutoCommit(false);
                
                // Synchronize changes with the database
                crs.acceptChanges(conn);
                
                // Commit the transaction
                conn.commit();
            } catch (SQLException e) {
                // Rollback in case of error
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                throw e;
            } finally {
                // Reset auto-commit and close connection
                if (conn != null) {
                    try {
                        conn.setAutoCommit(true);
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            // Verify changes in database
            crs.setCommand("SELECT * FROM employees ORDER BY id");
            crs.execute();

            System.out.println("\nAfter synchronizing with database:");
            printRowSet(crs);
        }
    }

    private static void printRowSet(CachedRowSet crs) throws SQLException {
        // Print column headers
        System.out.println("ID\tName\t\tDepartment\tSalary");
        System.out.println("-".repeat(50));

        // Print data
        while (crs.next()) {
            System.out.printf("%d\t%-15s\t%-10s\t%.2f%n",
                crs.getInt("id"),
                crs.getString("name"),
                crs.getString("department"),
                crs.getDouble("salary"));
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}