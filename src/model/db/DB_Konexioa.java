package model.db;

import java.sql.*;

/**
 * Klasea datu-basearekin konexioa ezartzeko erabiltzen da.
 */
public class DB_Konexioa {

	private static final String url = "jdbc:mysql://10.5.6.220:3306/DB_Sprotify"; // Datu-basearen URL-a
	private static final String user = "username"; // Datu-basearen erabiltzailea
	private static final String pass = "password"; // Datu-basearen pasahitza

	private static Connection conexioa; // Konexioa gordetzeko aldagaia

	/**
	 * Bezeroaren konexioa sortzen du.
	 * 
	 * @return Konexioa
	 */
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

	/**
	 * Adminaren konexioa sortzen du.
	 * 
	 * @return Konexioa
	 */
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

	/**
	 * Konexioa itxi.
	 * 
	 * @throws SQLException
	 */
	public static void itxi() throws SQLException {
		conexioa.close();
	}
}
