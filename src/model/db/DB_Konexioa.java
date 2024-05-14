package model.db;

import java.sql.*;

/**
 * Klasea datu-basearekin konexioa ezartzeko erabiltzen da.
 */
public class DB_Konexioa {

	private static final String url = "jdbc:mysql://10.5.6.220:3306/DB_Sprotify"; // Datu-basearen URL-a
	private static final String userBezero = "username"; // Datu-basearen erabiltzailea
	private static final String passBezero = "password"; // Datu-basearen pasahitza

	private static String userAdmin = ""; // Datu-basearen erabiltzailea
	private static String passAdmin = ""; // Datu-basearen pasahitza

	private static Connection conexioa; // Konexioa gordetzeko aldagaia

	/**
	 * Bezeroaren konexioa sortzen du.
	 * 
	 * @return Konexioa
	 */
	public static Connection bezeroa() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexioa = DriverManager.getConnection(url, userBezero, passBezero);

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

			conexioa = DriverManager.getConnection(url, userAdmin, passAdmin);
			
			return conexioa;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean testAdmin(String user, String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(url, user, pwd);
			userAdmin = user;
			passAdmin = pwd;
			return true;
		}catch (Exception ex) {
			return false;
		}
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
