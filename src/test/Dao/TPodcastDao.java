package test.Dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.dao.PodcastDao;
import model.db.DB_Konexioa;
import model.objektuak.Audio;
import model.objektuak.Podcast;
import model.objektuak.Podcaster;

public class TPodcastDao {

	private static PodcastDao podcastdao;
	private static ArrayList<Audio> testArray;
	private static Podcaster podcaster;
	
	@Before
	public void setUp() throws Exception {
		testArray = new ArrayList<>();
		podcastdao = new PodcastDao();
		podcaster = new Podcaster("1", "unai", null, "deskribapena");
	}

	@Test
	public void testgetPodcastByPodcasterId() throws SQLException {
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
		testArray = podcastdao.getPodcastByPodcasterId(podcaster);
		
		for (int i=0;i<testArray.size();i++) {
			assertEquals(retArray.get(i).getIdAudio(), testArray.get(i).getIdAudio());
			assertEquals(retArray.get(i).getIzena(), testArray.get(i).getIzena());
			assertEquals(retArray.get(i).getIraupena(), testArray.get(i).getIraupena());
		}
		
	}

}
