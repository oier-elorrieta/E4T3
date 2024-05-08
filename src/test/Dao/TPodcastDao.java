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
		podcaster = new Podcaster("PO001", "unai", null, "deskribapena");
	}

	@Test
	public void testgetPodcastByPodcasterId() throws SQLException {
		assertEquals(podcastdao.getPodcastByPodcasterId(podcaster).size(), 4);	
	}

}
