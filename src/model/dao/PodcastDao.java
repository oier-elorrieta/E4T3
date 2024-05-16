package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.db.DB_Konexioa;
import model.db.DB_funtzioak;
import model.objektuak.Abestia;
import model.objektuak.Audio;
import model.objektuak.Podcast;
import model.objektuak.Podcaster;

import model.db.DB_funtzioak;

public class PodcastDao {
	
	private final String defaultBlob = "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\r\n";
	Connection conex;

	/**
	 * Albumen ID_Album, Izenburua eta abesti kopuru kontzultatzen duen metodoa da.
	 * 
	 * @param ID_Album      -> ID_Album
	 * @param Izenburua     -> Albumanen izena
	 * @param abesti_kopuru -> Album horrek zenbat abesti dituen
	 * @return ArrayList albumekoa y datu ditu bakoitzak ID_Album, Izenburua eta
	 *         Abestiak
	 * @throws SQLException
	 */
	public ArrayList<Audio> getPodcastByPodcasterId(Podcaster podcaster) throws SQLException {
		ArrayList<Audio> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from PodcastIkusi where ID_Podcaster ='" + podcaster.getId() + "'";
		ResultSet podcasts = sentencia.executeQuery(kontsulta);

		Podcast PodcastAux;

		while (podcasts.next()) {
			PodcastAux = new Podcast(podcasts.getString("ID_Audio"), podcasts.getString("Izena"),
					podcasts.getInt("Iraupena"), podcasts.getString("Kolaboratzaileak"), podcasts.getBlob("Irudia"));
			retArray.add(PodcastAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	public boolean podcastGehitu(Podcast podcast, Podcaster podcaster) throws SQLException{
		conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "INSERT INTO Audio (ID_Audio, Izena, Iraupena,Irudia, Mota) VALUES ('"+ podcast.getIdAudio() + "', '" + podcast.getIzena() + "', '" + podcast.getIraupena() + "', FROM_BASE64('" + defaultBlob+ "'), '" + "Podcast" + "');";
		sentencia.executeUpdate(kontsulta);
		
		kolaboraboratzaileakGehitu(podcast,podcaster);
		
		DB_Konexioa.itxi();
		return true;
	}
	
	private void kolaboraboratzaileakGehitu(Podcast podcast, Podcaster podcaster) throws SQLException{
		Statement sent = conex.createStatement();
		String kontsulta = "INSERT INTO Podcast (ID_Audio, Kolaboratzaileak, ID_Podcaster) VALUES ('"+ podcast.getIdAudio() + "', '" + podcast.getKolaboratzaileak() + "', '" + podcaster.getId() + "');";
		sent.executeUpdate(kontsulta);
	}
	
	public void deletePodcastKolab(Audio audio) throws SQLException{
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "DELETE from Podcast where ID_Audio='" + audio.getIdAudio() +"';";
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
	}

}
