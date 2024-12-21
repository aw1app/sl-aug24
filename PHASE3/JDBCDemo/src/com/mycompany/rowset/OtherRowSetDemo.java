package com.mycompany.rowset;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class OtherRowSetDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/estore";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";

    public static void main(String[] args) {
        try {
            // Create sample data first
            createSampleData();

            // Demonstrate different RowSet types
            demonstrateWebRowSet();
            demonstrateJdbcRowSet();
            demonstrateFilteredRowSet();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createSampleData() throws SQLException {
        try (Connection conn = getConnection()) {
            var statement = conn.createStatement();

            // Drop and create table
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
                (3, 'Bob Wilson', 'IT', 80000.00),
                (4, 'Alice Brown', 'Finance', 70000.00)
            """);
        }
    }

    private static void demonstrateWebRowSet() throws SQLException, IOException {
        System.out.println("\n=== WebRowSet Demo ===");
        RowSetFactory factory = RowSetProvider.newFactory();
        try (WebRowSet webRowSet = factory.createWebRowSet()) {
            // Configure and execute query
            webRowSet.setUrl(URL);
            webRowSet.setUsername(USER);
            webRowSet.setPassword(PASSWORD);
            webRowSet.setCommand("SELECT * FROM employees");
            webRowSet.execute();

            // Write to XML file
            File xmlFile = new File("employees.xml");
            try (FileWriter writer = new FileWriter(xmlFile)) {
                webRowSet.writeXml(writer);
            }
            System.out.println("Data written to XML file");

            // Read from XML file
            try (FileReader reader = new FileReader(xmlFile)) {
                webRowSet.readXml(reader);
                System.out.println("\nData read from XML:");
                printRowSet(webRowSet);
            }
        }
    }

    private static void demonstrateJdbcRowSet() throws SQLException {
        System.out.println("\n=== JdbcRowSet Demo ===");
        RowSetFactory factory = RowSetProvider.newFactory();
        
        try (JdbcRowSet jdbcRowSet = factory.createJdbcRowSet()) {
            // Configure and execute query
            jdbcRowSet.setUrl(URL);
            jdbcRowSet.setUsername(USER);
            jdbcRowSet.setPassword(PASSWORD);
            jdbcRowSet.setCommand("SELECT * FROM employees");
            jdbcRowSet.execute();

            // Demonstrate scrolling and updates
            System.out.println("Original data:");
            printRowSet(jdbcRowSet);

            // Update salary for IT department
            jdbcRowSet.beforeFirst();
            while (jdbcRowSet.next()) {
                if ("IT".equals(jdbcRowSet.getString("department"))) {
                    double currentSalary = jdbcRowSet.getDouble("salary");
                    jdbcRowSet.updateDouble("salary", currentSalary * 1.1); // 10% increase
                    jdbcRowSet.updateRow();
                }
            }

            // Show updated data
            System.out.println("\nAfter salary update:");
            jdbcRowSet.beforeFirst();
            printRowSet(jdbcRowSet);
        }
    }

    private static void demonstrateFilteredRowSet() throws SQLException {
        System.out.println("\n=== FilteredRowSet Demo ===");
        RowSetFactory factory = RowSetProvider.newFactory();
        
        try (FilteredRowSet filteredRowSet = factory.createFilteredRowSet()) {
            // Configure and execute query
            filteredRowSet.setUrl(URL);
            filteredRowSet.setUsername(USER);
            filteredRowSet.setPassword(PASSWORD);
            filteredRowSet.setCommand("SELECT * FROM employees");
            filteredRowSet.execute();

            // Create and apply a salary filter
            SalaryFilter salaryFilter = new SalaryFilter(70000.0);
            filteredRowSet.setFilter(salaryFilter);

            System.out.println("Employees with salary > 70000:");
            printRowSet(filteredRowSet);
        }
    }

    // Custom Predicate for FilteredRowSet
    static class SalaryFilter implements Predicate {
        private double minSalary;

        public SalaryFilter(double minSalary) {
            this.minSalary = minSalary;
        }

        @Override
        public boolean evaluate(RowSet rs) {
            try {
                return rs.getDouble("salary") > minSalary;
            } catch (SQLException e) {
                return false;
            }
        }

        @Override
        public boolean evaluate(Object value, int column) throws SQLException {
            return false;
        }

        @Override
        public boolean evaluate(Object value, String columnName) throws SQLException {
            return false;
        }
    }

    private static void printRowSet(RowSet rs) throws SQLException {
        System.out.println("ID\tName\t\tDepartment\tSalary");
        System.out.println("-".repeat(50));
        
        while (rs.next()) {
            System.out.printf("%d\t%-15s\t%-10s\t%.2f%n",
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("department"),
                rs.getDouble("salary"));
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
