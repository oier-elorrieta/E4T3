package model.db;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;


import model.objektuak.*;



public class DB_funtzioak {
	
	public static boolean komprobatuErabiltzailea(String erabiltzailea, String pasahitza) throws SQLException {
		
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		
		String kontsulta = "SELECT * from Bezeroa where Erabiltzailea ='" + erabiltzailea + "'" ;
		ResultSet erabiltzaileak = sentencia.executeQuery(kontsulta);
		
		
		erabiltzaileak.next();
							
		if (BCrypt.checkpw(pasahitza,erabiltzaileak.getString("Pasahitza"))) {
			String pass = erabiltzaileak.getString("Pasahitza");
			pass = control.funtzioak.Funtzioak.enkriptatzailea(pass);
			model.Aldagaiak.erabiltzailea = new Free(erabiltzaileak.getString("Izen"),erabiltzaileak.getString("Abizena"),erabiltzaileak.getString("Hizkuntza"), erabiltzaileak.getString("Erabiltzailea"), pass, erabiltzaileak.getDate("Jaiotze_data"),erabiltzaileak.getDate("Erregistro_data"));
			DB_Konexioa.itxi(sentencia, erabiltzaileak);
			return true;
		}
			
		
		DB_Konexioa.itxi(sentencia, erabiltzaileak);
		return false;
	}
	
	public static boolean erregistratuErabiltzailea(Bezero erregistratu) throws SQLException {
		boolean premiumDa = erregistratu.getClass().getName().equals("Premium");
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "INSERT INTO Bezeroa (Izen, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotze_data, Erregistro_data, Mota) VALUES ('John', 'Doe', 'EN', 'john_doe', '$2a$10$u.U5anZzcNi5VRXyRgmr7.xmTclHT4LvDSFw.jKiAMvpVbmUu59eG', '1990-05-15', '2023-01-01', 'Free')," ;
		
		if(premiumDa) {
			
		}else {
			
		}
		
		return false;
	}
	
	
}
