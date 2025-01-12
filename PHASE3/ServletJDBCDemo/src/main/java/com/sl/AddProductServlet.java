package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	Statement stmt = null;

	public void init(ServletConfig config) {
		
		// String url =  getServletContext().getInitParameter("dburl");
		
		String url = config.getInitParameter("dburl");
		String user = config.getInitParameter("dbusername");
		String passwd = config.getInitParameter("dbpassword");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, passwd);
			stmt = connection.createStatement();
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		float price = Float.parseFloat(priceStr);

		String sql = "INSERT INTO eproducts(ProductName,Price)  values ('" + name + "'," + price + ")";
		try {
			int count = stmt.executeUpdate(sql);
			out.println("Successfuly add " + count + "(s) products");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("Could not add the product.Contact admin");
		}
		
		out.close();
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
