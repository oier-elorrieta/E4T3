package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

import control.funtzioak.Funtzioak;
import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.bezero.Bezero;
import model.objektuak.bezero.Free;

public class BezeroDao {
	
	/**
	 * Erabiltzailea eta pasahitza konprobatzen du datu-basean.
	 * 
	 * @param erabiltzailea Erabiltzailearen izena
	 * @param pasahitza     Pasahitza
	 * @return True badaude datu-basean eta pasahitza egokia bada, False bestela
	 * @throws SQLException
	 */
	public boolean komprobatuErabiltzailea(String erabiltzailea, String pasahitza) throws SQLException {

		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "SELECT * from Bezeroa where Erabiltzailea ='" + erabiltzailea + "'";
		ResultSet erabiltzaileak = sentencia.executeQuery(kontsulta);

		erabiltzaileak.next();

		if (BCrypt.checkpw(pasahitza, erabiltzaileak.getString("Pasahitza"))) {
			String pass = erabiltzaileak.getString("Pasahitza");
			pass = Funtzioak.enkriptatzailea(pass);
			Aldagaiak.erabiltzailea = new Free(erabiltzaileak.getString("Izen"), erabiltzaileak.getString("Abizena"),
					erabiltzaileak.getString("Hizkuntza"), erabiltzaileak.getString("Erabiltzailea"), pass,
					erabiltzaileak.getDate("Jaiotze_data"), erabiltzaileak.getDate("Erregistro_data"));
			DB_Konexioa.itxi();
			return true;
		}

		DB_Konexioa.itxi();
		return false;
	}
	
	/**
	 * Erabiltzaile bat datu-basean erregistratzen du.
	 * 
	 * @param erregistratu Erabiltzailea
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

		DB_Konexioa.itxi();
		return true;
	}
	
}	
