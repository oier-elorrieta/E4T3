package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.objektuak.Podcast;
import model.objektuak.Podcaster;

public class PodcastDao {

	
	/**
	 * Albumen ID_Album, Izenburua eta abesti kopuru kontzultatzen duen metodoa da.
	 * 
	 * @param ID_Album -> ID_Album 
	 * @param Izenburua -> Albumanen izena
	 * @param abesti_kopuru -> Album horrek zenbat abesti dituen
	 * @return ArrayList albumekoa y datu ditu bakoitzak ID_Album, Izenburua eta Abestiak
	 * @throws SQLException
	 */
	public ArrayList<Podcast> getPodcastById(Podcaster podcaster) throws SQLException {
		ArrayList<Podcast> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Podcast where ID_Podcast ='" + podcaster.getId() + "'";
		ResultSet podcasts = sentencia.executeQuery(kontsulta);

		Podcast PodcastAux;

		while (podcasts.next()) {
			PodcastAux = new Podcast(podcasts.getString("ID_Audio"), podcasts.getString("Kolaboratzailea"), podcasts.getString("ID_Podcaster"));
			retArray.add(PodcastAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
}

