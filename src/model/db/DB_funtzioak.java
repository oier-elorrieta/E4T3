package model.db;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import control.funtzioak.Funtzioak;
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
			model.Aldagaiak.erabiltzailea = new Free(erabiltzaileak.getString("Izen"),erabiltzaileak.getString("Abizena"),erabiltzaileak.getString("Hizkuntza"), erabiltzaileak.getString("Erabiltzailea"), pass, erabiltzaileak.getDate("Jaiotze_data"),erabiltzaileak.getDate("Erregistro_data"));
			DB_Konexioa.itxi();
			return true;
		}
			
		
		DB_Konexioa.itxi();
		return false;
	}
	
	public static boolean erregistratuErabiltzailea(Bezero erregistratu) throws SQLException {
		boolean premiumDa = erregistratu.getClass().getName().equals("Premium");
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "INSERT INTO Bezeroa (Izen, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotze_data, Erregistro_data, Mota) VALUES ('" + erregistratu.getIzena() +"', '" + erregistratu.getAbizena() +"', '" + erregistratu.getHizkuntza() +"', '" + erregistratu.getErabiltzaileIzena() +"', '" + erregistratu.getPasahitza() +"', '" + erregistratu.getJaioteguna() +"', '" + erregistratu.getJaioteguna() +"', '" + erregistratu.getClass().getName() +"')" ;
		sentencia.executeUpdate(kontsulta);
		
		if(premiumDa) {
			Premium premiumAux = (Premium) erregistratu;
			premiumBezeroa(premiumAux,conex,sentencia);
		}
		
		DB_Konexioa.itxi();
		return true;
	}
	
	private static void premiumBezeroa(Premium premium, Connection conex, Statement sentencia) throws SQLException{
		String kontsulta = "SELECT max(ID_Bezeroa) from Bezeroa" ;
		ResultSet bezeroID = sentencia.executeQuery(kontsulta);
		bezeroID.next();
		int bezero = bezeroID.getInt(0);
		
		
		String konsulta = "INSERT INTO Premium (ID_Bezeroa,Iraungitze_data) VALUES ('" + bezero + "', '" + premium.getIraungitzeData() + "')";
		sentencia.executeUpdate(kontsulta);

	}
	
	
}
