package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Musikaria;

public class MusikariaDao {
	
	/**
	 * Musikari guztiak bilatzen dituen metodoa da.
	 * 
	 * @param Musikaria objetua
	 * @return ArrayList musikaria-koa
	 * @throws SQLException
	 */
	public ArrayList<Musikaria> getMusikariak() throws SQLException{
		ArrayList<Musikaria> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from musikaDeskubritu";
		ResultSet erreprodukzioak = sentencia.executeQuery(kontsulta);

		Musikaria erreprodukzioaAux;

		while (erreprodukzioak.next()) {
			erreprodukzioaAux = new Musikaria(erreprodukzioak.getString("Musikaria"), erreprodukzioak.getInt("Erreprodukzioak"));
			retArray.add(erreprodukzioaAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	/**
	 * Musikari konkretu bat izenarekin bilatzen duen metodoa da.
	 * 
	 * @param Musikaria objetua
	 * @return Musikaria objetua
	 * @throws SQLException
	 */
	public Musikaria getMusikariaByIzena(String izena) throws SQLException{
		Musikaria musikariaRet;
		
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Musikaria where Izen_Artistikoa = '" + izena + "';";
		ResultSet musikaria = sentencia.executeQuery(kontsulta);
		
		musikaria.next();
		
		musikariaRet = new Musikaria(musikaria.getString("ID_Musikaria"), musikaria.getString("Izen_Artistikoa"), musikaria.getBlob("Irudia"), musikaria.getString("Deskribapena"), musikaria.getString("Ezaugarria"));
		
		DB_Konexioa.itxi();
		
		return musikariaRet;
		
	}
}
