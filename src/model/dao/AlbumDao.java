package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;


import model.objektuak.*;


public class AlbumDao {
	public ArrayList<Album> getAlbumakByMusikaria(Musikaria musikaria) throws SQLException {
		ArrayList<Album> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Album where ID_Musikaria ='"+musikaria.getId()+"'";
		ResultSet albumak = sentencia.executeQuery(kontsulta);

		Album AlbumAux;

		while (albumak.next()) {
			AlbumAux = new Album(albumak.getString("ID_Album"), albumak.getString("Izenburua"), albumak.getInt("Abestiak"));
			retArray.add(AlbumAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
}
