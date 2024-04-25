package model.dao;

import java.sql.*;
import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

import control.funtzioak.Funtzioak;
import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.bezero.*;

public class BezeroDao {
	
	/**
	 * Erabiltzailea eta pasahitza konprobatzen du datu-basean eta Bezero objectua sortzen du.
	 * 
	 * @param erabiltzailea -> Erabiltzailearen izena
	 * @param pasahitza -> Pasahitza
	 * @return True badaude datu-basean eta pasahitza egokia bada, False bestela
	 * @throws SQLException
	 */
	public boolean komprobatuErabiltzailea(String erabiltzailea, String pasahitza) throws SQLException {

		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "SELECT * from Bezeroa where Erabiltzailea ='" + erabiltzailea + "'";
		ResultSet erabiltzaileak = sentencia.executeQuery(kontsulta);

		
		
		if (!erabiltzaileak.next()) {
			DB_Konexioa.itxi();
			return false;
		}
		if (BCrypt.checkpw(pasahitza, erabiltzaileak.getString("Pasahitza"))) {
			String pass = erabiltzaileak.getString("Pasahitza");
			pass = Funtzioak.enkriptatzailea(pass);
			if(erabiltzaileak.getString("Mota").equals("Free")) {
				Aldagaiak.erabiltzailea = new Free(erabiltzaileak.getInt("ID_Bezeroa"), erabiltzaileak.getString("Izen"), erabiltzaileak.getString("Abizena"),
						erabiltzaileak.getString("Hizkuntza"), erabiltzaileak.getString("Erabiltzailea"), pasahitza,
						erabiltzaileak.getDate("Jaiotze_data"), erabiltzaileak.getDate("Erregistro_data"));
			} else {
				Date iraungitzeData = premiumOrdua(conex,erabiltzaileak.getInt("ID_Bezeroa"));
				Aldagaiak.erabiltzailea = new Premium(erabiltzaileak.getInt("ID_Bezeroa"), erabiltzaileak.getString("Izen"), erabiltzaileak.getString("Abizena"),
						erabiltzaileak.getString("Hizkuntza"), erabiltzaileak.getString("Erabiltzailea"), pasahitza,
						erabiltzaileak.getDate("Jaiotze_data"), erabiltzaileak.getDate("Erregistro_data"), iraungitzeData);
			}
			
			DB_Konexioa.itxi();
			return true;
		}

		DB_Konexioa.itxi();
		return false;
	}
	
	/**
	 * Premium bezeroaren iraungitze data hartzen du bezeroaren ID-arekin filtratzen
	 * 
	 * @param conex -> Erabiliko den konexioa
	 * @param idBezero -> Bezeroaren id-a
	 * @return Bezeroaren iraungitze data
	 * @throws SQLException
	 */
	
	private Date premiumOrdua(Connection conex, int idBezero) throws SQLException {
		Statement statement = conex.createStatement();
				
		String kontsulta = "SELECT Iraungitze_data from Premium where ID_bezeroa ="+idBezero+"";
		ResultSet iraungitzeData = statement.executeQuery(kontsulta);
		
		iraungitzeData.next();
		
		Date returnDate = new Date();
		returnDate = iraungitzeData.getDate("Iraungitze_data");
		
		return returnDate;
		
		
	}
	
	/**
	 * Erabiltzaile bat datu-basean erregistratzen du.
	 * 
	 * @param erregistratu Bezero objektua
	 * @return True bada erabiltzailea erregistratuta dagoen eta False bestela
	 * @throws SQLException
	 */
	public boolean erregistratuErabiltzailea(Bezero erregistratu) throws SQLException {
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		java.sql.Date sqlDateJaioteguna = new java.sql.Date(erregistratu.getJaioteguna().getTime());
		java.sql.Date erregistroDateJaioteguna = new java.sql.Date(erregistratu.getErregistroEguna().getTime());

		String kontsulta = "INSERT INTO Bezeroa (Izen, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotze_data, Erregistro_data, Mota) VALUES ('"
				+ erregistratu.getIzena() + "', '" + erregistratu.getAbizena() + "', '" + erregistratu.getHizkuntza()
				+ "', '" + erregistratu.getErabiltzaileIzena() + "', '" + erregistratu.getPasahitza() + "', '"
				+ sqlDateJaioteguna + "', '" + erregistroDateJaioteguna + "', '"
				+ erregistratu.getClass().getSimpleName() + "')";
		sentencia.executeUpdate(kontsulta);
		
		if(erregistratu.getClass().getSimpleName().equalsIgnoreCase("Premium")){
			Premium aux = (Premium) erregistratu; 
			erregistratuPremium(conex,erregistratu.getErabiltzaileIzena(),aux.getIraungitzeData());
		}

		DB_Konexioa.itxi();
		return true;
	}
	/**
	 * Premium den erabiltzailearen iraungitze data 
	 * 
	 * @param erregistratu Bezero objektua
	 * @return True bada erabiltzailea erregistratuta dagoen eta False bestela
	 * @throws SQLException
	 */
	
	private void erregistratuPremium(Connection conex, String erabiltzailea, Date iraungitzeData) throws SQLException {
		Statement statement = conex.createStatement();
		
		java.sql.Date sqlDateIraungitze = new java.sql.Date(iraungitzeData.getTime());
		
		String konsulta = "INSERT INTO Premium (ID_bezeroa, Iraungitze_data) VALUES ((SELECT ID_Bezeroa FROM Bezeroa WHERE Erabiltzailea='"+erabiltzailea+"'),'"+sqlDateIraungitze+"');"; 
		statement.executeUpdate(konsulta);
	}
	
}	
