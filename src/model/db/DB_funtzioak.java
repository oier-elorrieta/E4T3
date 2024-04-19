package model.db;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import control.funtzioak.Funtzioak;
import model.Aldagaiak;
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
			pass = Funtzioak.enkriptatzailea(pass);
			Aldagaiak.erabiltzailea = new Free(erabiltzaileak.getString("Izen"),erabiltzaileak.getString("Abizena"),erabiltzaileak.getString("Hizkuntza"), erabiltzaileak.getString("Erabiltzailea"), pass, erabiltzaileak.getDate("Jaiotze_data"),erabiltzaileak.getDate("Erregistro_data"));
			DB_Konexioa.itxi();
			return true;
		}
			
		
		DB_Konexioa.itxi();
		return false;
	}
	
	public static boolean erregistratuErabiltzailea(Bezero erregistratu) throws SQLException {
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		java.sql.Date sqlDateJaioteguna = new java.sql.Date(erregistratu.getJaioteguna().getTime());
		java.sql.Date erregistroDateJaioteguna = new java.sql.Date(erregistratu.getErregistroEguna().getTime());
		

		
		String kontsulta = "INSERT INTO Bezeroa (Izen, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotze_data, Erregistro_data, Mota) VALUES ('" + erregistratu.getIzena() +"', '" + erregistratu.getAbizena() +"', '" + erregistratu.getHizkuntza() +"', '" + erregistratu.getErabiltzaileIzena() +"', '" + erregistratu.getPasahitza() +"', '" + sqlDateJaioteguna +"', '" + erregistroDateJaioteguna +"', '" + erregistratu.getClass().getSimpleName() +"')" ;
		sentencia.executeUpdate(kontsulta);
		
	
		
		DB_Konexioa.itxi();
		return true;
	}
	
	public static ArrayList<Hizkuntza> getHizkuntzak() throws SQLException {
		ArrayList<Hizkuntza> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta ="select * from Hizkuntza" ;
		ResultSet hizkuntzak = sentencia.executeQuery(kontsulta);
		
		Hizkuntza HizkuntzaAux;
		
		while(hizkuntzak.next()) {
			HizkuntzaAux = new Hizkuntza(hizkuntzak.getString("ID_Hizkuntza"),hizkuntzak.getString("Deskribapena"));
			retArray.add(HizkuntzaAux);
		}
		
		
		DB_Konexioa.itxi();
		return retArray;
	}
	

	

	
	
}
