package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DB_Konexioa {
	
	private static final String url = "jdbc:mysql://10.5.6.220:3306/DB_Sprotify";
	private static final String user = "username";
	private static final String pass = "password";
	
	private static Connection conexioa;
	
	public static Connection bezeroa() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexioa = DriverManager.getConnection(url, user, pass);
			
			return conexioa;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return null;
	}
	public static Connection admin() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexioa = DriverManager.getConnection(url, user, pass);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return null;
	}
	public static void itxi() throws SQLException {
		conexioa.close();
	}
}
