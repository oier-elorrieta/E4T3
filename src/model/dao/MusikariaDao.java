package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
