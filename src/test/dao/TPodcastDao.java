package test.dao;

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
	private static Podcaster podcaster;
	private static Podcast p1;
	
	@Before
	public void setUp() throws Exception {
		podcastdao = new PodcastDao();
		podcaster = new Podcaster("PO001", "unai", null, "deskribapena");
		p1 = new Podcast("AU001", "The Wild Project #1", 12840, "Guest 1, Guest 2", null);
	}

	@Test
	public void testgetPodcastByPodcasterId() throws SQLException {
		assertEquals(podcastdao.getPodcastByPodcasterId(podcaster).get(0), p1);	
	}

}
