package edu.mum.mobile.store.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection conn = null;
	private static String url;
	private static String user;
	private static String password;

	public static void createConnection(String url, String user, String password) {
		try {
			ConnectionManager.url = url;
			ConnectionManager.user = user;
			ConnectionManager.password = password;
			
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.setLoginTimeout(1 * 24 * 60 * 60);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Opened connection sucessfully!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			if(!conn.isValid(3)) {
				createConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
			System.out.println("Closed connection sucessfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
