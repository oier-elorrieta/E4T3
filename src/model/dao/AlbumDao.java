package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.Aldagaiak;
import model.db.DB_Konexioa;


import model.objektuak.*;


public class AlbumDao {
	
	private final String defaultBlob = "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\r\n";

	
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
	
	public String getLastId() throws SQLException {
		String ret = "";
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "select ID_Album from Album ORDER BY char_length(ID_Album) desc, substr(ID_Album,3) desc;";
		ResultSet lastID = sentencia.executeQuery(kontsulta);
		try {
			lastID.next();
			ret = lastID.getString(1);
			conex.close();
			return ret;	
		}catch(SQLException e) {
			ret = "AL0";
			return ret;
		}
		
		
	}
	
	public void newAlbum(Album newAlbum, Musikaria musikaria) throws SQLException{
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		java.sql.Date sqlUrtea = new java.sql.Date(newAlbum.getUrtea().getTime());
		
		System.out.println(musikaria.getId());
		
		
		String kontsulta = "INSERT INTO Album (ID_Album, Izenburua, Urtea, Generoa,Irudia, Deskripzioa, ID_Musikaria) VALUES ('"+ newAlbum.getId() + "', '" + newAlbum.getIzenburua() + "', '" + sqlUrtea + "' , '" +newAlbum.getGeneroa() +"', '" +defaultBlob +"', '" +newAlbum.getDeskripzioa() +"', '" +musikaria.getId() +"');";
	
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
		
		}
	
	public boolean deleteAlbumById(Album album) throws SQLException{
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "DELETE from Album where ID_Album='" + album.getId() +"';";
		
		try {
			sentencia.executeUpdate(kontsulta);
			DB_Konexioa.itxi();
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			DB_Konexioa.itxi();
			return false;
		}
	}
		
	}



