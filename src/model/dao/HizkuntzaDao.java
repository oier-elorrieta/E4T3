package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Hizkuntza;

public class HizkuntzaDao {
	
	/**
	 * Datu-basean dauden hizkuntzak itzultzen ditu.
	 * 
	 * @return Hizkuntzak ArrayList-ean
	 * @throws SQLException
	 */
	public ArrayList<Hizkuntza> getHizkuntzak() throws SQLException {
		ArrayList<Hizkuntza> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Hizkuntza";
		ResultSet hizkuntzak = sentencia.executeQuery(kontsulta);

		Hizkuntza HizkuntzaAux;

		while (hizkuntzak.next()) {
			HizkuntzaAux = new Hizkuntza(hizkuntzak.getString("ID_Hizkuntza"), hizkuntzak.getString("Deskribapena"));
			retArray.add(HizkuntzaAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
}
