package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;


import model.objektuak.*;


public class AlbumDao {
	
	/**
	 * Musikari baten albumak kontsultatzeko metodoa. Albumek ID_Album, Izenburua eta Abesti kopurua 
	 * dituzte.
	 *
	 * @param musikaria Musikaria kontsultatzeko.
	 * @return ArrayList albumen zerrenda batekin, bakoitza ID_Album, Izenburua eta Abesti kopuruarekin.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public ArrayList<Album> getAlbumakByMusikaria(Musikaria musikaria) throws SQLException {
	    ArrayList<Album> retArray = new ArrayList<>();
	    Connection conex = DB_Konexioa.bezeroa();
	    
	    Statement sentencia = conex.createStatement();
	    String kontsulta = "select * from AlbumView where ID_Musikaria = '" + musikaria.getId() + "'";
	    ResultSet albumak = sentencia.executeQuery(kontsulta);
	    
	    while (albumak.next()) {
	        Album AlbumAux = new Album(
	            albumak.getString("ID_Album"),
	            albumak.getString("Izenburua"),
	            albumak.getInt("Abestiak")
	        );
	        retArray.add(AlbumAux);
	    }
	    
	    DB_Konexioa.itxi();
	    return retArray;
	}

	/**
	 * Album bat IDaren arabera kontsultatzeko metodoa.
	 *
	 * @param id Albumaren IDa.
	 * @return Album objektua, zeinak ID_Album, Izenburua, Urtea, Abesti Kopurua, Iraupena, Irudia, 
	 * eta Deskribapena dituen.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public Album getAlbumById(String id) throws SQLException {
	    Connection conex = DB_Konexioa.bezeroa();
	    
	    Statement sentencia = conex.createStatement();
	    String kontsulta = "select * from AlbumInfo where ID_Album = '" + id + "';";
	    ResultSet albuma = sentencia.executeQuery(kontsulta);
	    
	    albuma.next(); // Gure query-k gutxienez emaitza bat izan behar du.
	    
	    Album albumRet = new Album(
	        albuma.getString("ID_Album"),
	        albuma.getString("Izenburua"),
	        albuma.getDate("Urtea"),
	        albuma.getInt("AbestiKop"),
	        albuma.getInt("Iraupena"),
	        albuma.getBlob("Irudia"),
	        albuma.getString("Deskribapena")
	    );
	    
	    DB_Konexioa.itxi();
	    return albumRet;
	}

}

