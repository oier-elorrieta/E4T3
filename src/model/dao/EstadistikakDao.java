package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Estadistikak;

public class EstadistikakDao {
	
	public ArrayList<Estadistikak> getEstadistikak() throws SQLException {
		ArrayList<Estadistikak> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from EstadistikakIkusi";
		ResultSet estadistika = sentencia.executeQuery(kontsulta);

		Estadistikak estadistikakAux;

		while (estadistika.next()) {
			estadistikakAux = new Estadistikak(estadistika.getString("ID_Audio"), estadistika.getString("Izena"), estadistika.getInt("Erreprodukzio_Kop_Egunero"), estadistika.getInt("Erreprodukzio_Kop_Hilabetero"), estadistika.getInt("Erreprodukzio_Kop_Urtero"));
			retArray.add(estadistikakAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
}
