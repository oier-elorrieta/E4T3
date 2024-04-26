package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;


import model.objektuak.*;


public class AlbumDao {
	
	/**
	 * Albumen ID_Album, Izenburua eta abesti kopuru kontzultatzen duen metodoa da.
	 * 
	 * @param ID_Album -> ID_Album 
	 * @param Izenburua -> Albumanen izena
	 * @param abesti_kopuru -> Album horrek zenbat abesti dituen
	 * @return ArrayList albumekoa y datu ditu bakoitzak ID_Album, Izenburua eta Abestiak
	 * @throws SQLException
	 */
	public ArrayList<Album> getAlbumakByMusikaria(Musikaria musikaria) throws SQLException {
		ArrayList<Album> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from AlbumView where ID_Musikaria ='" + musikaria.getId() + "'";
		ResultSet albumak = sentencia.executeQuery(kontsulta);

		Album AlbumAux;

		while (albumak.next()) {
			AlbumAux = new Album(albumak.getString("ID_Album"), albumak.getString("Izenburua"), albumak.getInt("Abestiak"));
			retArray.add(AlbumAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	public Album getAlbumById(String id) throws SQLException{
		Album albumRet;
		
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from AlbumInfo where ID_Album = '" + id + "';";
		ResultSet albuma = sentencia.executeQuery(kontsulta);
		
		albuma.next();
		
		albumRet = new Album(albuma.getString("ID_Album"), albuma.getString("Izenburua"), albuma.getDate("Urtea"), albuma.getInt("AbestiKop"), albuma.getInt("Iraupena"), albuma.getBlob("Irudia"));
		
		DB_Konexioa.itxi();
		
		return albumRet;
		
	}
}

