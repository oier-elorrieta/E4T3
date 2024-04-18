package model.db;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;



public class DB_funtzioak {
	
	public static boolean komprobatuErabiltzailea(String erabiltzailea, String pasahitza) throws SQLException {
		
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		
		String kontsulta = "SELECT * from Bezeroa";
		ResultSet erabiltzaileak = sentencia.executeQuery(kontsulta);
		
		while(erabiltzaileak.next()) {
			
			if (erabiltzaileak.getString("Erabiltzailea").equals(erabiltzailea)) {
				
				if (BCrypt.checkpw(pasahitza,erabiltzaileak.getString("Pasahitza"))) {
				
					String pass = erabiltzaileak.getString("Pasahitza");
					pass = BCrypt.hashpw(pass, BCrypt.gensalt());
					// Bezero erabiltzaile = new Free(erabiltzaileak.getString("Izen"),erabiltzaileak.getString("Abizena"),erabiltzaileak.getString("Hizkuntza"), erabiltzaileak.getString("Erabiltzailea"), pass, erabiltzaileak.getDate("Jaiotze_data"),erabiltzaileak.getDate("Erregistro_data"));
					DB_Konexioa.itxi(sentencia, erabiltzaileak);
					return true;
				}
			}
		}
		DB_Konexioa.itxi(sentencia, erabiltzaileak);
		return false;
	}
}
