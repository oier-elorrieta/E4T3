package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Audio;
import model.objektuak.PlayList;

public class AbestiaDao {
	
	/**
	 * Albumen ID_Album, Izenburua eta abesti kopuru kontzultatzen duen metodoa da.
	 * 
	 * @param ID_Album -> ID_Album 
	 * @param Izenburua -> Albumanen izena
	 * @param abesti_kopuru -> Album horrek zenbat abesti dituen
	 * @return ArrayList albumekoa y datu ditu bakoitzak ID_Album, Izenburua eta Abestiak
	 * @throws SQLException
	 */
	public ArrayList<Audio> getAbestiaByAlbumId(Album album) throws SQLException {
		ArrayList<Audio> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Abestia join Audio using(ID_Audio) where ID_Album ='" + album.getId() + "'";
		ResultSet podcasts = sentencia.executeQuery(kontsulta);

		Abestia AbestiAux;

		while (podcasts.next()) {
			AbestiAux = new Abestia(podcasts.getString("ID_Audio"), podcasts.getString("Izena"), podcasts.getInt("Iraupena"), podcasts.getBlob("Irudia"));
			retArray.add(AbestiAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	public ArrayList<Audio> getAbestiaByPlayListID(PlayList playlist) throws SQLException {
		ArrayList<Audio> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();
		String kontsulta;
		if (playlist.getId().equals("noID")) {
			kontsulta = "select * from Gustokoak join Audio using(ID_Audio) where ID_Bezeroa ='" + Aldagaiak.erabiltzailea.getId() + "'";
			
		}else {
			System.out.println("playlist");
			kontsulta = "select * from Playlist_Abestiak join Audio using(ID_Audio) where ID_List ='" + playlist.getId() + "'";
		}
		ResultSet abestiak = sentencia.executeQuery(kontsulta);

		Abestia AbestiAux;

		while (abestiak.next()) {
			AbestiAux = new Abestia(abestiak.getString("ID_Audio"), abestiak.getString("Izena"), abestiak.getInt("Iraupena"), abestiak.getBlob("Irudia"));
			retArray.add(AbestiAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	public boolean abestiaGehitu(Audio audio, Album album) throws SQLException{
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "INSERT INTO Abestia (ID_Audio, ID_Album) VALUES ('"+ audio.getIdAudio() + "', '" + album.getId() + "');";
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
		return true;
	}
}
