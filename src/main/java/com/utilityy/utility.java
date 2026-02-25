package com.utilityy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utility {

	static Connection c;

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return c;
	}

}
