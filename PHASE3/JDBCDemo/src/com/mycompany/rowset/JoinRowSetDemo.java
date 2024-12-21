package com.mycompany.rowset;

import javax.sql.rowset.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JoinRowSetDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/estore";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";

    public static void main(String[] args) {
        try {
            // Create sample data
            createSampleData();

            // Demonstrate JoinRowSet
            demonstrateJoinRowSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createSampleData() throws SQLException {
        try (Connection conn = getConnection()) {
            var statement = conn.createStatement();

            // Create and populate employees table
            statement.execute("DROP TABLE IF EXISTS employees");
            statement.execute("""
                CREATE TABLE employees (
                    emp_id INT PRIMARY KEY,
                    name VARCHAR(100),
                    dept_id INT,
                    salary DECIMAL(10,2)
                )
            """);

            statement.execute("""
                INSERT INTO employees (emp_id, name, dept_id, salary) VALUES
                (1, 'John Doe', 1, 75000.00),
                (2, 'Jane Smith', 2, 65000.00),
                (3, 'Bob Wilson', 1, 80000.00),
                (4, 'Alice Brown', 3, 70000.00),
                (5, 'Charlie Davis', 2, 68000.00)
            """);

            // Create and populate departments table
            statement.execute("DROP TABLE IF EXISTS departments");
            statement.execute("""
                CREATE TABLE departments (
                    dept_id INT PRIMARY KEY,
                    dept_name VARCHAR(50),
                    location VARCHAR(100)
                )
            """);

            statement.execute("""
                INSERT INTO departments (dept_id, dept_name, location) VALUES
                (1, 'IT', 'New York'),
                (2, 'HR', 'Chicago'),
                (3, 'Finance', 'Boston')
            """);

            // Create and populate projects table
            statement.execute("DROP TABLE IF EXISTS projects");
            statement.execute("""
                CREATE TABLE projects (
                    project_id INT PRIMARY KEY,
                    project_name VARCHAR(100),
                    dept_id INT,
                    budget DECIMAL(12,2)
                )
            """);

            statement.execute("""
                INSERT INTO projects (project_id, project_name, dept_id, budget) VALUES
                (1, 'Cloud Migration', 1, 500000.00),
                (2, 'HR System Upgrade', 2, 300000.00),
                (3, 'Financial Analysis', 3, 250000.00),
                (4, 'Security Audit', 1, 400000.00)
            """);
        }
    }

    private static void demonstrateJoinRowSet() throws SQLException {
        RowSetFactory factory = RowSetProvider.newFactory();

        // Create CachedRowSets for each table
        CachedRowSet employeesRS = factory.createCachedRowSet();
        CachedRowSet departmentsRS = factory.createCachedRowSet();
        CachedRowSet projectsRS = factory.createCachedRowSet();

        // Configure and populate CachedRowSets
        // Employees
        employeesRS.setUrl(URL);
        employeesRS.setUsername(USER);
        employeesRS.setPassword(PASSWORD);
        employeesRS.setCommand("SELECT * FROM employees");
        employeesRS.execute();

        // Departments
        departmentsRS.setUrl(URL);
        departmentsRS.setUsername(USER);
        departmentsRS.setPassword(PASSWORD);
        departmentsRS.setCommand("SELECT * FROM departments");
        departmentsRS.execute();

        // Projects
        projectsRS.setUrl(URL);
        projectsRS.setUsername(USER);
        projectsRS.setPassword(PASSWORD);
        projectsRS.setCommand("SELECT * FROM projects");
        projectsRS.execute();

        try (JoinRowSet joinRS = factory.createJoinRowSet()) {
            // First join: Employees with Departments
            joinRS.addRowSet(departmentsRS, "dept_id");
            joinRS.addRowSet(employeesRS, "dept_id");

            System.out.println("\n=== Employees with their Departments ===");
            System.out.println("Employee\tDepartment\tLocation\tSalary");
            System.out.println("-".repeat(60));

            while (joinRS.next()) {
                System.out.printf("%-15s\t%-12s\t%-12s\t%.2f%n",
                    joinRS.getString("name"),
                    joinRS.getString("dept_name"),
                    joinRS.getString("location"),
                    joinRS.getDouble("salary"));
            }

            // Reset JoinRowSet for new join
            joinRS.release();

            // Second join: Departments with Projects
            joinRS.addRowSet(departmentsRS, "dept_id");
            joinRS.addRowSet(projectsRS, "dept_id");

            System.out.println("\n=== Departments with their Projects ===");
            System.out.println("Department\tLocation\tProject\t\t\tBudget");
            System.out.println("-".repeat(70));

            while (joinRS.next()) {
                System.out.printf("%-12s\t%-12s\t%-20s\t%.2f%n",
                    joinRS.getString("dept_name"),
                    joinRS.getString("location"),
                    joinRS.getString("project_name"),
                    joinRS.getDouble("budget"));
            }

            // Advanced join with all three tables
            joinRS.release();
            
            // Create a new CachedRowSet with a specific query for three-way join
            CachedRowSet threeWayJoinRS = factory.createCachedRowSet();
            threeWayJoinRS.setUrl(URL);
            threeWayJoinRS.setUsername(USER);
            threeWayJoinRS.setPassword(PASSWORD);
            threeWayJoinRS.setCommand("""
                SELECT e.name, d.dept_name, p.project_name, p.budget
                FROM employees e
                JOIN departments d ON e.dept_id = d.dept_id
                JOIN projects p ON d.dept_id = p.dept_id
                ORDER BY e.name
            """);
            threeWayJoinRS.execute();

            System.out.println("\n=== Employees with Departments and Projects ===");
            System.out.println("Employee\tDepartment\tProject\t\t\tBudget");
            System.out.println("-".repeat(70));

            while (threeWayJoinRS.next()) {
                System.out.printf("%-15s\t%-12s\t%-20s\t%.2f%n",
                    threeWayJoinRS.getString("name"),
                    threeWayJoinRS.getString("dept_name"),
                    threeWayJoinRS.getString("project_name"),
                    threeWayJoinRS.getDouble("budget"));
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}