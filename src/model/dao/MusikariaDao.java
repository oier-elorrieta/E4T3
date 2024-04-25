package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Musikaria;

public class MusikariaDao {
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
	
	public Musikaria getMusikariaByIzena(String izena) throws SQLException{
		Musikaria musikariaRet;
		
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Musikaria";
		ResultSet musikaria = sentencia.executeQuery(kontsulta);
		
		musikaria.next();
		
		musikariaRet = new Musikaria(musikaria.getString("ID_Musikaria"), musikaria.getString("Izen_Artistikoa"), musikaria.getString("Irudia"), musikaria.getString("Deskribapena"), musikaria.getString("Ezaugarria"));
		
		DB_Konexioa.itxi();
		
		return musikariaRet;
		
	}
}
