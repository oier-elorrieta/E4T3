package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Album;
import model.objektuak.Audio;
import model.objektuak.Podcast;
import model.objektuak.Podcaster;

public class AudioDao {
	
	
	/**
	 * Albumen ID_Album, Izenburua eta abesti kopuru kontzultatzen duen metodoa da.
	 * 
	 * @param ID_Album -> ID_Album 
	 * @param Izenburua -> Albumanen izena
	 * @param abesti_kopuru -> Album horrek zenbat abesti dituen
	 * @return ArrayList albumekoa y datu ditu bakoitzak ID_Album, Izenburua eta Abestiak
	 * @throws SQLException
	 */
	public ArrayList<Audio> getAudio(Album album) throws SQLException {
		ArrayList<Audio> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Audio join Abestia using(ID_Audio) where ID_Album ='" + album.getId() + "'";
		ResultSet podcasts = sentencia.executeQuery(kontsulta);

		Audio AudioAux;

		while (podcasts.next()) {
			AudioAux = new Audio(podcasts.getString("ID_Audio"), podcasts.getString("Izena"), podcasts.getInt("Iraupena"), podcasts.getString("Kolaboratzaileak"));
			retArray.add(AudioAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
}

